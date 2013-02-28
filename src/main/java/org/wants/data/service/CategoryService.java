/**
 * 
 */
package org.wants.data.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.wants.data.entity.CategoryInfo;
import org.wants.data.exception.DataException;

/**
 * @author jiangzm
 * 
 */
public interface CategoryService {
	/**
	 * @param parent
	 * @return
	 * @see org.wants.data.repository.CategoryRepository#findByParent(java.lang.String)
	 */
	public List<CategoryInfo> findByParent(String parent) throws DataException;

	/**
	 * @param category
	 * @return
	 * @see org.wants.data.repository.CategoryRepository#findByCategory(java.lang.String)
	 */
	public CategoryInfo findByCategory(String category) throws DataException;

	/**
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	public <S extends CategoryInfo> S save(S entity) throws DataException;

	/**
	 * @param entites
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#save(java.lang.Iterable)
	 */
	public <S extends CategoryInfo> List<S> save(Iterable<S> entites) throws DataException;

	/**
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll()
	 */
	public List<CategoryInfo> findAll() throws DataException;

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	public Page<CategoryInfo> findAll(Pageable pageable) throws DataException;

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	public CategoryInfo findOne(String id) throws DataException;

	/**
	 * @param sort
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll(org.springframework.data.domain.Sort)
	 */
	public List<CategoryInfo> findAll(Sort sort) throws DataException;

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
	public Iterable<CategoryInfo> findAll(Iterable<String> ids) throws DataException;

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
	public void delete(CategoryInfo entity) throws DataException;

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	public void delete(Iterable<? extends CategoryInfo> entities) throws DataException;

	/**
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	public void deleteAll() throws DataException;

	/**
	 * @param parent
	 * @param pageRequest
	 * @return
	 * @throws DataException
	 */
	public Page<CategoryInfo> findByParent(String parent, Pageable pageRequest) throws DataException;

	/**
	 * @param name
	 * @return
	 * @see org.wants.data.repository.CategoryRepository#findByName(java.lang.String)
	 */
	public List<CategoryInfo> findByName(String name) throws DataException;

	/**
	 * @param name
	 * @param pageRequest
	 * @return
	 * @see org.wants.data.repository.CategoryRepository#findByName(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	public Page<CategoryInfo> findByName(String name, Pageable pageRequest) throws DataException;
}
