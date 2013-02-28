/**
 * 
 */
package org.wants.data.entity;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.wants.data.jsonp.JsonpResponse;
import org.wants.data.meta.AjaxResponseCode;
import org.wants.data.meta.AjaxResponseStatus;

/**
 * @author jiangzm
 * 
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AjaxResponse implements Serializable, JsonpResponse {

	private Integer status;

	private Integer code;

	private String msg;

	private String devMsg;

	private Object addition;

	private String callback;

	private String ftl;

	public AjaxResponse() {
		super();
		this.status = AjaxResponseStatus.OK.getCode();
		this.code = AjaxResponseCode.SUCCESS.getCode();
	}

	public AjaxResponse(Integer status, Integer code) {
		super();
		this.status = status;
		this.code = code;
	}

	public AjaxResponse(Integer status, Integer code, String msg) {
		super();
		this.status = status;
		this.code = code;
		this.msg = msg;
	}

	public String getFtl() {
		return ftl;
	}

	public void setFtl(String ftl) {
		this.ftl = ftl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDevMsg() {
		return devMsg;
	}

	public void setDevMsg(String devMsg) {
		this.devMsg = devMsg;
	}

	public Object getAddition() {
		return addition;
	}

	public void setAddition(Object addition) {
		this.addition = addition;
	}

	@Override
	public void setCallback(String callback) {
		this.callback = callback;
	}

	@Override
	public String getCallback() {
		return callback;
	}

}
