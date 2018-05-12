package com.AIRetail.Model;

import java.util.ArrayList;
import java.util.List;
import com.AIRetail.Model.CityModel;

public class ZoneModel {
	private String name;
	private List<CityModel> cities = new ArrayList();
	private Integer zoneID;

	public Integer getZoneID() {
		return this.zoneID;
	}

	public void setZoneID(Integer zoneID) {
		this.zoneID = zoneID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CityModel> getCities() {
		return this.cities;
	}

	public void setCities(List<CityModel> cities) {
		this.cities = cities;
	}

}
