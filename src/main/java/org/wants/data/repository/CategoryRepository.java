package org.wants.data.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.wants.data.entity.CategoryInfo;

public interface CategoryRepository extends MongoRepository<CategoryInfo, String> {
	public List<CategoryInfo> findByParent(String parent);

	public Page<CategoryInfo> findByParent(String parent, Pageable pageRequest);

	public List<CategoryInfo> findByName(String name);

	public Page<CategoryInfo> findByName(String name, Pageable pageRequest);

	public CategoryInfo findByCategory(String category);

}
