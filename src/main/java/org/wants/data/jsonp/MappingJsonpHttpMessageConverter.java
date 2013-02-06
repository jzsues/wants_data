/**
 * 
 */
package org.wants.data.jsonp;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.Assert;
import org.wants.data.entity.AjaxResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author jiangzm
 * 
 */
public class MappingJsonpHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {

	final Logger logger = LoggerFactory.getLogger(getClass());

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	private ObjectMapper objectMapper = new ObjectMapper();

	private Boolean prettyPrint;

	private Configuration configuration;

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	/**
	 * Construct a new {@code MappingJacksonHttpMessageConverter}.
	 */
	public MappingJsonpHttpMessageConverter() {
		super(new MediaType("application", "javascript", DEFAULT_CHARSET), new MediaType("application", "*+javascript", DEFAULT_CHARSET));
	}

	/**
	 * Set the {@code ObjectMapper} for this view. If not set, a default
	 * {@link ObjectMapper#ObjectMapper() ObjectMapper} is used.
	 * <p>
	 * Setting a custom-configured {@code ObjectMapper} is one way to take
	 * further control of the JSON serialization process. For example, an
	 * extended {@link org.codehaus.jackson.map.SerializerFactory} can be
	 * configured that provides custom serializers for specific types. The other
	 * option for refining the serialization process is to use Jackson's
	 * provided annotations on the types to be serialized, in which case a
	 * custom-configured ObjectMapper is unnecessary.
	 */
	public void setObjectMapper(ObjectMapper objectMapper) {
		Assert.notNull(objectMapper, "ObjectMapper must not be null");
		this.objectMapper = objectMapper;
		configurePrettyPrint();
	}

	private void configurePrettyPrint() {
		if (this.prettyPrint != null) {
			this.objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, this.prettyPrint);
		}
	}

	/**
	 * Return the underlying {@code ObjectMapper} for this view.
	 */
	public ObjectMapper getObjectMapper() {
		return this.objectMapper;
	}

	/**
	 * Whether to use the {@link DefaultPrettyPrinter} when writing JSON. This
	 * is a shortcut for setting up an {@code ObjectMapper} as follows:
	 * 
	 * <pre>
	 * ObjectMapper mapper = new ObjectMapper();
	 * mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
	 * converter.setObjectMapper(mapper);
	 * </pre>
	 * <p>
	 * The default value is {@code false}.
	 */
	public void setPrettyPrint(boolean prettyPrint) {
		this.prettyPrint = prettyPrint;
		configurePrettyPrint();
	}

	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		return canRead((Type) clazz, null, mediaType);
	}

	public boolean canRead(Type type, Class<?> contextClass, MediaType mediaType) {
		JavaType javaType = getJavaType(type, contextClass);
		return (this.objectMapper.canDeserialize(javaType) && canRead(mediaType));
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		return (this.objectMapper.canSerialize(clazz) && canWrite(mediaType));
	}

	@Override
	protected boolean supports(Class<?> clazz) {
		// should not be called, since we override canRead/Write instead
		throw new UnsupportedOperationException();
	}

	@Override
	protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

		JavaType javaType = getJavaType(clazz, null);
		return readJavaType(javaType, inputMessage);
	}

	public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

		JavaType javaType = getJavaType(type, contextClass);
		return readJavaType(javaType, inputMessage);
	}

	private Object readJavaType(JavaType javaType, HttpInputMessage inputMessage) {
		try {
			return this.objectMapper.readValue(inputMessage.getBody(), javaType);
		} catch (IOException ex) {
			throw new HttpMessageNotReadableException("Could not read JSON: " + ex.getMessage(), ex);
		}
	}

	private void populateFtl(Object obj, String ftl, StringBuilder html) throws IOException {
		StringWriter out = new StringWriter();
		Template template = configuration.getTemplate(ftl + ".ftl");
		try {
			template.process(obj, out);
			String str = out.toString();
			html.append(str);
		} catch (TemplateException e) {
			logger.error(e.getMessage());
		} finally {
			out.close();
		}

	}

	@Override
	protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

		JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
		JsonGenerator jsonGenerator = this.objectMapper.getJsonFactory().createJsonGenerator(outputMessage.getBody(), encoding);
		// A workaround for JsonGenerators not applying serialization features
		// https://github.com/FasterXML/jackson-databind/issues/12
		if (this.objectMapper.getSerializationConfig().isEnabled(SerializationConfig.Feature.INDENT_OUTPUT)) {
			jsonGenerator.useDefaultPrettyPrinter();
		}

		try {
			if (object instanceof AjaxResponse) {
				AjaxResponse jsonp = (AjaxResponse) object;
				String ftl = jsonp.getFtl();
				if (!StringUtils.isEmpty(ftl)) {
					if (jsonp.getAddition() != null) {
						Map<String, Object> obj = new HashMap<String, Object>();
						obj.put("datas", jsonp.getAddition());
						StringBuilder html = new StringBuilder();
						populateFtl(obj, ftl, html);
						jsonp.setAddition(html.toString());
					}
				}
				String callback = jsonp.getCallback();
				callback = (callback == null) ? "callback" : callback;
				jsonGenerator.writeRaw(callback);
				jsonGenerator.writeRaw("(");
				this.objectMapper.writeValue(jsonGenerator, object);
				jsonGenerator.writeRaw(");");
				jsonGenerator.flush();
			} else {
				this.objectMapper.writeValue(jsonGenerator, object);
			}

		} catch (JsonProcessingException ex) {
			throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
		}
	}

	/**
	 * Return the Jackson {@link JavaType} for the specified type and context
	 * class.
	 * <p>
	 * The default implementation returns
	 * {@link TypeFactory#type(java.lang.reflect.Type)} or
	 * {@code TypeFactory.type(type, TypeFactory.type(contextClass))}, but this
	 * can be overridden in subclasses, to allow for custom generic collection
	 * handling. For instance:
	 * 
	 * <pre class="code">
	 * protected JavaType getJavaType(Type type) {
	 * 	if (type instanceof Class &amp;&amp; List.class.isAssignableFrom((Class) type)) {
	 * 		return TypeFactory.collectionType(ArrayList.class, MyBean.class);
	 * 	} else {
	 * 		return super.getJavaType(type);
	 * 	}
	 * }
	 * </pre>
	 * 
	 * @param type
	 *            the type to return the java type for
	 * @param contextClass
	 *            a context class for the target type, for example a class in
	 *            which the target type appears in a method signature, can be
	 *            {@code null}
	 * @return the java type
	 */
	@SuppressWarnings("deprecation")
	protected JavaType getJavaType(Type type, Class<?> contextClass) {
		return (contextClass != null) ? TypeFactory.type(type, TypeFactory.type(contextClass)) : TypeFactory.type(type);
	}

	/**
	 * Determine the JSON encoding to use for the given content type.
	 * 
	 * @param contentType
	 *            the media type as requested by the caller
	 * @return the JSON encoding to use (never <code>null</code>)
	 */
	protected JsonEncoding getJsonEncoding(MediaType contentType) {
		if (contentType != null && contentType.getCharSet() != null) {
			Charset charset = contentType.getCharSet();
			for (JsonEncoding encoding : JsonEncoding.values()) {
				if (charset.name().equals(encoding.getJavaName())) {
					return encoding;
				}
			}
		}
		return JsonEncoding.UTF8;
	}

}
