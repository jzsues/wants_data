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

	private String r_desc;

	private String r_dimensions;

	private String r_dimensions_unit;

	private String r_weight;

	private String r_weight_unit;

	private String r_shipping;

	private String r_origin;

	private String r_review;

	public String getR_desc() {
		return r_desc;
	}

	public void setR_desc(String r_desc) {
		this.r_desc = r_desc;
	}

	public String getR_dimensions() {
		return r_dimensions;
	}

	public void setR_dimensions(String r_dimensions) {
		this.r_dimensions = r_dimensions;
	}

	public String getR_dimensions_unit() {
		return r_dimensions_unit;
	}

	public void setR_dimensions_unit(String r_dimensions_unit) {
		this.r_dimensions_unit = r_dimensions_unit;
	}

	public String getR_weight() {
		return r_weight;
	}

	public void setR_weight(String r_weight) {
		this.r_weight = r_weight;
	}

	public String getR_weight_unit() {
		return r_weight_unit;
	}

	public void setR_weight_unit(String r_weight_unit) {
		this.r_weight_unit = r_weight_unit;
	}

	public String getR_shipping() {
		return r_shipping;
	}

	public void setR_shipping(String r_shipping) {
		this.r_shipping = r_shipping;
	}

	public String getR_origin() {
		return r_origin;
	}

	public void setR_origin(String r_origin) {
		this.r_origin = r_origin;
	}

	public String getR_review() {
		return r_review;
	}

	public void setR_review(String r_review) {
		this.r_review = r_review;
	}

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

	public String[] getThumbs() {
		return thumbs;
	}

	public void setThumbs(String[] thumbs) {
		this.thumbs = thumbs;
	}

}
