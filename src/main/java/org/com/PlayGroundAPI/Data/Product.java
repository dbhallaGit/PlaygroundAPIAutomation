package org.com.PlayGroundAPI.Data;

import java.awt.List;

import org.json.JSONArray;

public class Product {
	
	String id,name,type,price,upc,shipping,description,manufacturer,model,url,image,createdAt,updatedAt;	
	ProductCategories[] categories;	

	
	public ProductCategories[] getCategories() {
		return categories;
	}

	public void setCategories(ProductCategories[] categories) {
		this.categories = categories;
	}

	Product(){}
	
	public Product( String id,String name,String type,String price,String upc,String shipping,String description,String manufacturer,String model,String url,String image,ProductCategories[] categories) {
		this.id=id;
		this.name=name;
		this.type=type;
		this.price=price;
		this.upc=upc;
		this.shipping=shipping;
		this.description=description;
		this.manufacturer=manufacturer;
		this.model=model;
		this.url=url;
		this.image=image;
		this.categories=categories;
	}
	
	
	

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}


  
 
