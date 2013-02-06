/**
 * 
 */
package org.wants.data.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.wants.data.entity.ItemInfo;
import org.wants.data.entity.RankInfo;
import org.wants.data.exception.DataException;
import org.wants.data.repository.ItemRepository;
import org.wants.data.repository.RankRepository;
import org.wants.data.service.RankService;

/**
 * @author jzsues
 * 
 */
@Service
public class RankServiceImpl implements RankService {
	Log logger = LogFactory.getLog(getClass());
	@Autowired
	RankRepository rankRepository;

	@Autowired
	ItemRepository itemRepository;

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
	public List<RankInfo> findByBatchAndCategoryAndType(String batch, String category, String type, Sort sort) throws DataException {
		try {
			return rankRepository.findByBatchAndCategoryAndType(batch, category, type, sort);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

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
			throws DataException {
		try {
			return rankRepository.findByBatchAndCategoryAndType(batch, category, type, pageRequest);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	public Page<ItemInfo> findItemByBatchAndCategoryAndType(String batch, String category, String type, Pageable pageRequest)
			throws DataException {
		Page<RankInfo> ranks = this.findByBatchAndCategoryAndType(batch, category, type, pageRequest);
		LinkedList<String> asins = new LinkedList<String>();
		for (RankInfo rank : ranks) {
			asins.add(rank.getAsin());
		}
		List<ItemInfo> items = itemRepository.findByAsinIn(asins);
		return new PageImpl<ItemInfo>(items, pageRequest, items.size());
	}

	/**
	 * @param asin
	 * @param sort
	 * @return
	 * @see org.wants.data.repository.RankRepository#findByAsin(java.lang.String,
	 *      org.springframework.data.domain.Sort)
	 */
	public List<RankInfo> findByAsin(String asin, Sort sort) throws DataException {
		try {
			return rankRepository.findByAsin(asin, sort);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param asin
	 * @param pageRequest
	 * @return
	 * @see org.wants.data.repository.RankRepository#findByAsin(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	public Page<RankInfo> findByAsin(String asin, Pageable pageRequest) throws DataException {
		try {
			return rankRepository.findByAsin(asin, pageRequest);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	public <S extends RankInfo> S save(S entity) throws DataException {
		try {
			return rankRepository.save(entity);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entites
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#save(java.lang.Iterable)
	 */
	public <S extends RankInfo> List<S> save(Iterable<S> entites) throws DataException {
		try {
			return rankRepository.save(entites);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll()
	 */
	public List<RankInfo> findAll() throws DataException {
		try {
			return rankRepository.findAll();
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	public Page<RankInfo> findAll(Pageable pageable) throws DataException {
		try {
			return rankRepository.findAll(pageable);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	public RankInfo findOne(String id) throws DataException {
		try {
			return rankRepository.findOne(id);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param sort
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll(org.springframework.data.domain.Sort)
	 */
	public List<RankInfo> findAll(Sort sort) throws DataException {
		try {
			return rankRepository.findAll(sort);
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
			return rankRepository.exists(id);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param ids
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
	 */
	public Iterable<RankInfo> findAll(Iterable<String> ids) throws DataException {
		try {
			return rankRepository.findAll(ids);
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
			return rankRepository.count();
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
			rankRepository.delete(id);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entity
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	public void delete(RankInfo entity) throws DataException {
		try {
			rankRepository.delete(entity);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	public void delete(Iterable<? extends RankInfo> entities) throws DataException {
		try {
			rankRepository.delete(entities);
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
			rankRepository.deleteAll();
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

}
