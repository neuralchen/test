package com.AIRetail.Model.Test;

import java.util.List;

public class HeatmapDataModel {
	private Integer rankid;
	private String timestamp;
	private List<Integer> data;
	public Integer getRankid() {
		return rankid;
	}
	public void setRankid(Integer rankid) {
		this.rankid = rankid;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
}
