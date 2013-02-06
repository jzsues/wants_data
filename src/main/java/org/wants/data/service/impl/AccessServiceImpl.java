/**
 * 
 */
package org.wants.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wants.data.entity.AccessInfo;
import org.wants.data.exception.BizException;
import org.wants.data.repository.AccessRepository;
import org.wants.data.service.AccessService;

/**
 * @author jiangzm
 * 
 */
@Service
public class AccessServiceImpl implements AccessService {

	@Autowired
	AccessRepository accessRepository;

	@Override
	public List<AccessInfo> findByIp(String ip) throws BizException {
		try {
			return accessRepository.findByIp(ip);
		} catch (Exception e) {
			throw new BizException(e.getCause());
		}
	}

	@Override
	public AccessInfo save(AccessInfo access) throws BizException {
		try {
			return accessRepository.save(access);
		} catch (Exception e) {
			throw new BizException(e.getCause());
		}

	}

}
