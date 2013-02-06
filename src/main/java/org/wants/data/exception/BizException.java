/**
 * 
 */
package org.wants.data.exception;

/**
 * @author jiangzm
 * 
 */
public class BizException extends Exception {

	private static final long serialVersionUID = 2585596575595867338L;

	/**
	 * 
	 */
	public BizException() {
	}

	/**
	 * @param arg0
	 */
	public BizException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public BizException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public BizException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
