package com.mansi.student.service;

import com.mansi.student.model.LoginModel;

public interface LoginService  {

	void saveLoginData(LoginModel model);
	
	LoginModel getLoginData(String username,String pwd);
	
	LoginModel getUserByUnm(String unm);
}
