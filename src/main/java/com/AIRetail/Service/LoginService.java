package com.AIRetail.Service;


public interface LoginService {
	public String doLogin(String userlabel,String passwd,boolean remember);
	public void doLogout();
}
