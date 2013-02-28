/**
 * 
 */
package org.wants.data.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.wants.data.entity.ItemInfo;
import org.wants.data.exception.DataException;

/**
 * @author jzsues
 * 
 */
public interface ItemService {
	/**
	 * @param asin
	 * @return
	 * @see org.wants.data.repository.ItemRepository#findByAsin(java.lang.String)
	 */
	public ItemInfo findByAsin(String asin) throws DataException;

	/**
	 * @param asins
	 * @return
	 * @see org.wants.data.repository.ItemRepository#findByAsinIn(java.util.Collection)
	 */
	public List<ItemInfo> findByAsinIn(Collection<String> asins) throws DataException;

	/**
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	public <S extends ItemInfo> S save(S entity) throws DataException;

	/**
	 * @param entites
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#save(java.lang.Iterable)
	 */
	public <S extends ItemInfo> List<S> save(Iterable<S> entites) throws DataException;

	/**
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll()
	 */
	public List<ItemInfo> findAll() throws DataException;

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	public Page<ItemInfo> findAll(Pageable pageable) throws DataException;

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	public ItemInfo findOne(String id) throws DataException;

	/**
	 * @param sort
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll(org.springframework.data.domain.Sort)
	 */
	public List<ItemInfo> findAll(Sort sort) throws DataException;

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
	public Iterable<ItemInfo> findAll(Iterable<String> ids) throws DataException;

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
	public void delete(ItemInfo entity) throws DataException;

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	public void delete(Iterable<? extends ItemInfo> entities) throws DataException;

	/**
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	public void deleteAll() throws DataException;
}
