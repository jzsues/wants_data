/**
 * 
 */
package org.wants.data.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.wants.data.entity.PublishInfo;

/**
 * @author jzsues
 * 
 */
public interface PublishRepository extends MongoRepository<PublishInfo, String> {
	public PublishInfo findByBatchAndCategoryAndType(String batch, String category, String type, Sort sort);

	public PublishInfo findByBatch(String batch, Sort sort);

	public PublishInfo findByCategoryAndType(String category, String type, Sort sort);
}
