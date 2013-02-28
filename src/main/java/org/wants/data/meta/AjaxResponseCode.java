/**
 * 
 */
package org.wants.data.meta;

/**
 * @author jiangzm
 * 
 */
public enum AjaxResponseCode {
	SUCCESS(-1), ERROR(100);

	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	private AjaxResponseCode(Integer code) {
		this.code = code;
	}
}
