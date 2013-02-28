/**
 * 
 */
package org.wants.data.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.wants.data.entity.ItemInfo;
import org.wants.data.entity.RankInfo;
import org.wants.data.exception.DataException;

/**
 * @author jzsues
 * 
 */
public interface RankService {
	/**
	 * @param batch
	 * @param category
	 * @param type
	 * @param sort
	 * @return
	 * @see org.wants.data.repository.RankRepository#findByBatchAndCategoryAndType(java.lang.String,
	 *      java.lang.String, java.lang.String,
	 *      org.springframework.data.domain.Sort)
	 */
	public List<RankInfo> findByBatchAndCategoryAndType(String batch, String category, String type, Sort sort) throws DataException;

	/**
	 * @param batch
	 * @param category
	 * @param type
	 * @param pageRequest
	 * @return
	 * @see org.wants.data.repository.RankRepository#findByBatchAndCategoryAndType(java.lang.String,
	 *      java.lang.String, java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	public Page<RankInfo> findByBatchAndCategoryAndType(String batch, String category, String type, Pageable pageRequest)
			throws DataException;

	/**
	 * @param batch
	 * @param category
	 * @param type
	 * @param pageRequest
	 * @return
	 * @throws DataException
	 */
	public Page<ItemInfo> findItemByBatchAndCategoryAndType(String batch, String category, String type, Pageable pageRequest)
			throws DataException;

	/**
	 * @param asin
	 * @param sort
	 * @return
	 * @see org.wants.data.repository.RankRepository#findByAsin(java.lang.String,
	 *      org.springframework.data.domain.Sort)
	 */
	public List<RankInfo> findByAsin(String asin, Sort sort) throws DataException;

	/**
	 * @param asin
	 * @param pageRequest
	 * @return
	 * @see org.wants.data.repository.RankRepository#findByAsin(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	public Page<RankInfo> findByAsin(String asin, Pageable pageRequest) throws DataException;

	/**
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	public <S extends RankInfo> S save(S entity) throws DataException;

	/**
	 * @param entites
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#save(java.lang.Iterable)
	 */
	public <S extends RankInfo> List<S> save(Iterable<S> entites) throws DataException;

	/**
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll()
	 */
	public List<RankInfo> findAll() throws DataException;

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	public Page<RankInfo> findAll(Pageable pageable) throws DataException;

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	public RankInfo findOne(String id) throws DataException;

	/**
	 * @param sort
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll(org.springframework.data.domain.Sort)
	 */
	public List<RankInfo> findAll(Sort sort) throws DataException;

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#exists(java.io.Serializable)
	 */
	public boolean exists(String id) throws DataException;

	/**
	 * @param ids
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
	 */
	public Iterable<RankInfo> findAll(Iterable<String> ids) throws DataException;

	/**
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	public long count() throws DataException;

	/**
	 * @param id
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
	 */
	public void delete(String id) throws DataException;

	/**
	 * @param entity
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	public void delete(RankInfo entity) throws DataException;

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	public void delete(Iterable<? extends RankInfo> entities) throws DataException;

	/**
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	public void deleteAll() throws DataException;
}
