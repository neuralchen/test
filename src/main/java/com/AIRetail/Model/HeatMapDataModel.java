package com.AIRetail.Model;

import java.io.Serializable;
import java.util.*;

import com.AIRetail.Entity.ShopStructureEntity;

public class HeatMapDataModel implements Serializable {
	private ShopStructureEntity shopstructure;
	private List<SingleHeatMapModel> data;
	public ShopStructureEntity getShopstructure() {
		return shopstructure;
	}
	public void setShopstructure(ShopStructureEntity shopstructure) {
		this.shopstructure = shopstructure;
	}
	public List<SingleHeatMapModel> getData() {
		return data;
	}
	public void setData(List<SingleHeatMapModel> data) {
		this.data = data;
	}
	
}
