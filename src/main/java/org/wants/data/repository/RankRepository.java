/**
 * 
 */
package org.wants.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.wants.data.entity.RankInfo;

/**
 * @author jiangzm
 * 
 */
public interface RankRepository extends MongoRepository<RankInfo, String> {

	public List<RankInfo> findByBatchAndCategoryAndType(String batch, String category, String type, Sort sort);

	public Page<RankInfo> findByBatchAndCategoryAndType(String batch, String category, String type, Pageable pageRequest);

	public List<RankInfo> findByAsin(String asin, Sort sort);

	public Page<RankInfo> findByAsin(String asin, Pageable pageRequest);

}
