package com.AIRetail.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CityModel implements Serializable {
	private List<ShopInfoModel> shopes=new ArrayList();
	private String name;
	private Integer cityID;
		
	public Integer getCityID() {
		return this.cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShopes(List<ShopInfoModel> shopes) {
		this.shopes = shopes;
	}

	public List<ShopInfoModel> getShopes(){
		return this.shopes;
	}
}
