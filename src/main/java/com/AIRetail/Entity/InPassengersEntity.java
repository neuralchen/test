package com.AIRetail.Entity;

import java.sql.Timestamp;

public class InPassengersEntity {
private Integer rankid;
private String facepic;
private String gender;
private String age;
private String wholebodypic;
private Timestamp timestamp;

public Integer getRankid() {
	return rankid;
}
public void setRankid(Integer rankid) {
	this.rankid = rankid;
}
public String getFacepic() {
	return facepic;
}
public void setFacepic(String facepic) {
	this.facepic = facepic;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getWholebodypic() {
	return wholebodypic;
}
public void setWholebodypic(String wholebodypic) {
	this.wholebodypic = wholebodypic;
}
public Timestamp getTimestamp() {
	return timestamp;
}
public void setTimestamp(Timestamp time_stamp) {
	this.timestamp = time_stamp;
}

}
