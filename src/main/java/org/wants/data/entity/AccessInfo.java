/**
 * 
 */
package org.wants.data.entity;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jiangzm
 * 
 */
@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "access_info")
public class AccessInfo implements Serializable {
	@Id
	private String id;

	private String user_agent;

	private String cookie;

	private String ip;

	private String referer;

	private Long timestamp;

	private String language;

	private String request_url;

	private String query_string;

	public AccessInfo() {
		super();
	}

	public AccessInfo(String user_agent, String cookie, String ip, String referer, Long timestamp, String language,
			String request_url, String query_string) {
		super();
		this.user_agent = user_agent;
		this.cookie = cookie;
		this.ip = ip;
		this.referer = referer;
		this.timestamp = timestamp;
		this.language = language;
		this.request_url = request_url;
		this.query_string = query_string;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getUser_agent() {
		return user_agent;
	}

	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getRequest_url() {
		return request_url;
	}

	public void setRequest_url(String request_url) {
		this.request_url = request_url;
	}

	public String getQuery_string() {
		return query_string;
	}

	public void setQuery_string(String query_string) {
		this.query_string = query_string;
	}

}
