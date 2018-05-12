package com.AIRetail.Model;

import java.sql.Timestamp;
import java.util.List;

public class PostHeatmapModel {
	private String token;
	private Integer rankid;
	private String timestamp;
	private List<Integer> data;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
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
