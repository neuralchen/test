package com.AIRetail.Model;

import java.io.Serializable;
import java.util.*;

public class ShopInfoModel implements Serializable {
	
	private Integer x_grid_count;
	private Integer y_grid_count;
	private String name;
	private Integer shopID;
	private List<Integer> shopShape=new ArrayList();
	public Integer getX_grid_count() {
		return this.x_grid_count;
	}
	public void setX_grid_count(Integer x_grid_count) {
		this.x_grid_count = x_grid_count;
	}
	public Integer getY_grid_count() {
		return this.y_grid_count;
	}
	public void setY_grid_count(Integer y_grid_count) {
		this.y_grid_count = y_grid_count;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getShopID() {
		return this.shopID;
	}
	public void setShopID(Integer shopID) {
		this.shopID = shopID;
	}
	public List<Integer> getShopShape() {
		return this.shopShape;
	}
	public void setShopShape(List<Integer> shopShape) {
		this.shopShape = shopShape;
	}
	
}
