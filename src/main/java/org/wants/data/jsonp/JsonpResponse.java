/**
 * 
 */
package org.wants.data.jsonp;

/**
 * @author jiangzm
 * 
 */
public interface JsonpResponse {
	public void setCallback(final String jsonCallback);

	public String getCallback();
}
