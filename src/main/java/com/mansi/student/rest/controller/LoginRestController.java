package com.mansi.student.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mansi.student.model.LoginModel;
import com.mansi.student.service.LoginService;

@RestController
public class LoginRestController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("addLoginData")
	@ResponseBody
	public ResponseEntity<?> addLoginData(){
			
		LoginModel t = new LoginModel();
		t.setUserName("teacher");
		t.setPassword("teacher");
		t.setRole("T");
		t.setActive(true);
		LoginModel a = new LoginModel();
		a.setUserName("admin");
		a.setPassword("admin");
		a.setRole("A");
		a.setActive(true);
		loginService.saveLoginData(t);
		loginService.saveLoginData(a);
		return new ResponseEntity<String>("Successfully Added...",HttpStatus.OK);
	}

}
