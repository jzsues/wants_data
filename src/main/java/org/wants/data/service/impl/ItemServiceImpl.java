/**
 * 
 */
package org.wants.data.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.wants.data.entity.ItemInfo;
import org.wants.data.exception.DataException;
import org.wants.data.repository.ItemRepository;
import org.wants.data.service.ItemService;

/**
 * @author jzsues
 * 
 */
@Service
public class ItemServiceImpl implements ItemService {
	Log logger = LogFactory.getLog(getClass());
	@Autowired
	ItemRepository itemRepository;

	/**
	 * @param asin
	 * @return
	 * @see org.wants.data.repository.ItemRepository#findByAsin(java.lang.String)
	 */
	public ItemInfo findByAsin(String asin) throws DataException {
		try {
			return itemRepository.findByAsin(asin);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param asins
	 * @return
	 * @see org.wants.data.repository.ItemRepository#findByAsinIn(java.util.Collection)
	 */
	public List<ItemInfo> findByAsinIn(Collection<String> asins) throws DataException {
		try {
			return itemRepository.findByAsinIn(asins);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	public <S extends ItemInfo> S save(S entity) throws DataException {
		try {
			return itemRepository.save(entity);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entites
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#save(java.lang.Iterable)
	 */
	public <S extends ItemInfo> List<S> save(Iterable<S> entites) throws DataException {
		try {
			return itemRepository.save(entites);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll()
	 */
	public List<ItemInfo> findAll() throws DataException {
		try {
			return itemRepository.findAll();
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	public Page<ItemInfo> findAll(Pageable pageable) throws DataException {
		try {
			return itemRepository.findAll(pageable);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	public ItemInfo findOne(String id) throws DataException {
		try {
			return itemRepository.findOne(id);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param sort
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll(org.springframework.data.domain.Sort)
	 */
	public List<ItemInfo> findAll(Sort sort) throws DataException {
		try {
			return itemRepository.findAll(sort);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#exists(java.io.Serializable)
	 */
	public boolean exists(String id) throws DataException {
		try {
			return itemRepository.exists(id);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param ids
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
	 */
	public Iterable<ItemInfo> findAll(Iterable<String> ids) throws DataException {
		try {
			return itemRepository.findAll(ids);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	public long count() throws DataException {
		try {
			return itemRepository.count();
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param id
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
	 */
	public void delete(String id) throws DataException {
		try {
			itemRepository.delete(id);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entity
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	public void delete(ItemInfo entity) throws DataException {
		try {
			itemRepository.delete(entity);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	public void delete(Iterable<? extends ItemInfo> entities) throws DataException {
		try {
			itemRepository.delete(entities);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	public void deleteAll() throws DataException {
		try {
			itemRepository.deleteAll();
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

}
