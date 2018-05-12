package com.AIRetail.Model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustomerDataGender implements Serializable {
	private Timestamp time_stamp;
	private Integer female;
	private Integer male;
	
	public Timestamp getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(Timestamp time_stamp) {
		this.time_stamp = time_stamp;
	}
	public Integer getFemale() {
		return female;
	}
	public void setFemale(Integer female) {
		this.female = female;
	}
	public Integer getMale() {
		return male;
	}
	public void setMale(Integer male) {
		this.male = male;
	}
}
