package com.AIRetail.Entity;

import java.sql.Timestamp;

public class HeatmapDataEntity {
	private Integer rankid;
	private Timestamp ts;
	private String data;

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Integer getRankid() {
		return rankid;
	}

	public void setRankid(Integer rankid) {
		this.rankid = rankid;
	}
	
}
