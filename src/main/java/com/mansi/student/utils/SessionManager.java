package com.mansi.student.utils;

import java.io.Serializable;

import com.mansi.student.model.LoginModel;

public class SessionManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private LoginModel user;
	private boolean isLogin;

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public LoginModel getUser() {
		return user;
	}

	public void setUser(LoginModel user) {
		this.user = user;
	}
	
	
}
