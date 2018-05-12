package com.AIRetail.Model;

import java.sql.Timestamp;
import java.util.List;

public class SingleHeatMapModel {
	private Timestamp ts;
	private List<Integer> data;
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
}
