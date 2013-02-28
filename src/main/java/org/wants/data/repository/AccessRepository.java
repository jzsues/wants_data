/**
 * 
 */
package org.wants.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.wants.data.entity.AccessInfo;

/**
 * @author jiangzm
 * 
 */
public interface AccessRepository extends MongoRepository<AccessInfo, Long> {
	List<AccessInfo> findByIp(String ip);
}
