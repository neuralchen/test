package com.AIRetail.Entity;

import java.io.Serializable;

public class UserEntity implements Serializable {
private Integer userid;
private String userlabel;
private String passwd;
private Integer rankid;
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public String getUserlabel() {
	return userlabel;
}
public void setUserlabel(String userlabel) {
	this.userlabel = userlabel;
}
public String getPasswd() {
	return passwd;
}
public void setPasswd(String passwd) {
	this.passwd = passwd;
}
public Integer getRankid() {
	return rankid;
}
public void setRankid(Integer rankid) {
	this.rankid = rankid;
}

}
