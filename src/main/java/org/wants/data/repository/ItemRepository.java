package org.wants.data.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.wants.data.entity.ItemInfo;

public interface ItemRepository extends MongoRepository<ItemInfo, String> {
	public ItemInfo findByAsin(String asin);

	public List<ItemInfo> findByAsinIn(Collection<String> asins);
}
