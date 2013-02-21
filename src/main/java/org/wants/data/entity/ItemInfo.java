package org.wants.data.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "ama_item_detail")
public class ItemInfo implements Serializable {
	@Id
	private String id;

	private String asin;

	private String cover_img;

	private String list_price;

	private String price;

	private String you_save;

	private String name;

	private String prd_desc;

	private Map<String, String> prd_details;

	private List<String> prd_features;

	private Map<String, String> prd_spec;

	private String[] thumbs;

	private String version;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getCover_img() {
		return cover_img;
	}

	public void setCover_img(String cover_img) {
		this.cover_img = cover_img;
	}

	public String getList_price() {
		return list_price;
	}

	public void setList_price(String list_price) {
		this.list_price = list_price;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getYou_save() {
		return you_save;
	}

	public void setYou_save(String you_save) {
		this.you_save = you_save;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrd_desc() {
		return prd_desc;
	}

	public void setPrd_desc(String prd_desc) {
		this.prd_desc = prd_desc;
	}

	public String[] getThumbs() {
		return thumbs;
	}

	public void setThumbs(String[] thumbs) {
		this.thumbs = thumbs;
	}

	public Map<String, String> getPrd_details() {
		return prd_details;
	}

	public void setPrd_details(Map<String, String> prd_details) {
		this.prd_details = prd_details;
	}

	public List<String> getPrd_features() {
		return prd_features;
	}

	public void setPrd_features(List<String> prd_features) {
		this.prd_features = prd_features;
	}

	public Map<String, String> getPrd_spec() {
		return prd_spec;
	}

	public void setPrd_spec(Map<String, String> prd_spec) {
		this.prd_spec = prd_spec;
	}

}
