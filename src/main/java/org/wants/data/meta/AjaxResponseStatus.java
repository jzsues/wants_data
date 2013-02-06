/**
 * 
 */
package org.wants.data.meta;

/**
 * @author jiangzm
 * 
 */
public enum AjaxResponseStatus {
	OK(200), BAD_REQUEST(400), UNAUTHORIZED(401), FORBIDDEN(403), METHOD_NOT_ALLOWED(405), NOT_ACCEPTABLE(406), INTERNAL_SERVER_ERROR(500);

	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	private AjaxResponseStatus(Integer code) {
		this.code = code;
	}

}
