/**
 * 
 */
package org.wants.data.exception;

/**
 * @author jiangzm
 * 
 */
public class DataException extends BizException {

	private static final long serialVersionUID = 2195819035297695208L;

	/**
	 * 
	 */
	public DataException() {
	}

	/**
	 * @param arg0
	 */
	public DataException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public DataException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public DataException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
