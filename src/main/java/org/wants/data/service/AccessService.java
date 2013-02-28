/**
 * 
 */
package org.wants.data.service;

import java.util.List;

import org.wants.data.entity.AccessInfo;
import org.wants.data.exception.BizException;

/**
 * @author jiangzm
 * 
 */
public interface AccessService {
	public List<AccessInfo> findByIp(String ip) throws BizException;

	public AccessInfo save(AccessInfo access) throws BizException;
}
