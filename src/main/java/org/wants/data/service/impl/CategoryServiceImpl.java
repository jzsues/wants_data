/**
 * 
 */
package org.wants.data.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.wants.data.entity.CategoryInfo;
import org.wants.data.exception.DataException;
import org.wants.data.repository.CategoryRepository;
import org.wants.data.service.CategoryService;

/**
 * @author jzsues
 * 
 */
@Service
public class CategoryServiceImpl implements CategoryService {
	Log logger = LogFactory.getLog(getClass());

	@Autowired
	CategoryRepository categoryRespository;

	/**
	 * @param parent
	 * @return
	 * @see org.wants.data.repository.CategoryRepository#findByParent(java.lang.String)
	 */
	public List<CategoryInfo> findByParent(String parent) throws DataException {
		try {
			return categoryRespository.findByParent(parent);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param category
	 * @return
	 * @see org.wants.data.repository.CategoryRepository#findByCategory(java.lang.String)
	 */
	public CategoryInfo findByCategory(String category) throws DataException {
		try {
			return categoryRespository.findByCategory(category);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entity
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	public <S extends CategoryInfo> S save(S entity) throws DataException {
		try {
			return categoryRespository.save(entity);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entites
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#save(java.lang.Iterable)
	 */
	public <S extends CategoryInfo> List<S> save(Iterable<S> entites) throws DataException {
		try {
			return categoryRespository.save(entites);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll()
	 */
	public List<CategoryInfo> findAll() throws DataException {
		try {
			return categoryRespository.findAll();
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param pageable
	 * @return
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
	 */
	public Page<CategoryInfo> findAll(Pageable pageable) throws DataException {
		try {
			return categoryRespository.findAll(pageable);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param id
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	public CategoryInfo findOne(String id) throws DataException {
		try {
			return categoryRespository.findOne(id);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param sort
	 * @return
	 * @see org.springframework.data.mongodb.repository.MongoRepository#findAll(org.springframework.data.domain.Sort)
	 */
	public List<CategoryInfo> findAll(Sort sort) throws DataException {
		try {
			return categoryRespository.findAll(sort);
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
			return categoryRespository.exists(id);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param ids
	 * @return
	 * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
	 */
	public Iterable<CategoryInfo> findAll(Iterable<String> ids) throws DataException {
		try {
			return categoryRespository.findAll(ids);
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
			return categoryRespository.count();
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
			categoryRespository.delete(id);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entity
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	public void delete(CategoryInfo entity) throws DataException {
		try {
			categoryRespository.delete(entity);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param entities
	 * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
	 */
	public void delete(Iterable<? extends CategoryInfo> entities) throws DataException {
		try {
			categoryRespository.delete(entities);
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
			categoryRespository.deleteAll();
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param parent
	 * @param pageRequest
	 * @return
	 * @see org.wants.data.repository.CategoryRepository#findByParent(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	public Page<CategoryInfo> findByParent(String parent, Pageable pageRequest) throws DataException {
		try {
			return categoryRespository.findByParent(parent, pageRequest);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param name
	 * @return
	 * @see org.wants.data.repository.CategoryRepository#findByName(java.lang.String)
	 */
	public List<CategoryInfo> findByName(String name) throws DataException {
		try {
			return categoryRespository.findByName(name);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

	/**
	 * @param name
	 * @param pageRequest
	 * @return
	 * @see org.wants.data.repository.CategoryRepository#findByName(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	public Page<CategoryInfo> findByName(String name, Pageable pageRequest) throws DataException {
		try {
			return categoryRespository.findByName(name, pageRequest);
		} catch (Exception e) {
			throw new DataException(e);
		}
	}

}
