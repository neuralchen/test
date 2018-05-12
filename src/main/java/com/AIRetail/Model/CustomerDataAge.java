package com.AIRetail.Model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustomerDataAge implements Serializable {
	private Timestamp time_stamp;
	//20岁及以下
	private Integer a1;
	//21-30
	private Integer a2;
	//31-40
	private Integer a3;
	//41-50
	private Integer a4;
	//51-60
	private Integer a5;
	//61岁及以上
	private Integer a6;
	
	public Timestamp getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(Timestamp time_stamp) {
		this.time_stamp = time_stamp;
	}
	public Integer getA1() {
		return a1;
	}
	public void setA1(Integer a1) {
		this.a1 = a1;
	}
	public Integer getA2() {
		return a2;
	}
	public void setA2(Integer a2) {
		this.a2 = a2;
	}
	public Integer getA3() {
		return a3;
	}
	public void setA3(Integer a3) {
		this.a3 = a3;
	}
	public Integer getA4() {
		return a4;
	}
	public void setA4(Integer a4) {
		this.a4 = a4;
	}
	public Integer getA5() {
		return a5;
	}
	public void setA5(Integer a5) {
		this.a5 = a5;
	}
	public Integer getA6() {
		return a6;
	}
	public void setA6(Integer a6) {
		this.a6 = a6;
	}
}