/**
 * 
 */
package org.wants.data.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangzm
 * 
 */
public enum ItemRankType {
	BESTSELLERS("bestsellers"), NEW_RELEASES("new-releases"), MOVERS_AND_SHAKERS("movers-and-shakers"), TOP_RATED("top-rated"), MOST_WISHED_FOR(
			"most-wished-for"), MOST_GIFTED("most-gifted");

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private ItemRankType(String type) {
		this.type = type;
	}

	public static List<String> getTypes() {
		ItemRankType[] types = ItemRankType.values();
		List<String> sTypes = new ArrayList<String>();
		for (ItemRankType type : types) {
			sTypes.add(type.getType());
		}
		return sTypes;
	}

}
