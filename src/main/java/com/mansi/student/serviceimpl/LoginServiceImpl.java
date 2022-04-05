package com.mansi.student.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mansi.student.model.LoginModel;
import com.mansi.student.repository.LoginRepo;
import com.mansi.student.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepo loginRepo;
	
	@Override
	public void saveLoginData(LoginModel model) {
		// TODO Auto-generated method stub
		loginRepo.save(model);
	}

	@Override
	public LoginModel getLoginData(String username, String pwd) {
		// TODO Auto-generated method stub
		return loginRepo.getUserByNamePwd(username, pwd);
	}

	@Override
	public LoginModel getUserByUnm(String unm) {
		// TODO Auto-generated method stub
		return loginRepo.getUserByUnm(unm);
	}

}
