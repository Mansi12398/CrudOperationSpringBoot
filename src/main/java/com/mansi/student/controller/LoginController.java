package com.mansi.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mansi.student.model.LoginModel;
import com.mansi.student.model.StudentModel;
import com.mansi.student.service.LoginService;
import com.mansi.student.service.StudentService;
import com.mansi.student.utils.IConstants;
import com.mansi.student.utils.SessionManager;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private StudentService studentService;
	@GetMapping("/")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if(request.getSession().getAttribute(IConstants.loginAtt) != null) {
			SessionManager session = (SessionManager) request.getSession().getAttribute(IConstants.loginAtt);
			if(session.isLogin()) {
				if(session.getUser().getRole().equals("A") || session.getUser().getRole().equals("T")) {
					List<StudentModel> students = studentService.getAllStudent();
					if(students != null) {
						model.addObject("studentDetails", students);
					}
					System.out.println("ROLE = "+session.getUser().getRole());
				}else {
					StudentModel student = studentService.getStudentByUnm(session.getUser().getUserName());
					if(student != null) {
						model.addObject("student", student);
					}
				}
				
				model.addObject("role",session.getUser().getRole());
				model.setViewName("student");				
			}

		}else {
			model.setViewName("login");
		}
		return model;
	}
	
	@PostMapping("verifyLogin")
	public ModelAndView verifyLogin(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		if((username != null & pwd != null)&&(!username.isEmpty() && !pwd.isEmpty())) {
			model.setViewName("redirect:dashboard?unm="+username+"&pwd="+pwd);
		}else {
			model.setViewName("login");
		}
		System.out.println("username = " +username + " password = " + pwd);
		
		return model;
	}
	
	@GetMapping("dashboard")
	public ModelAndView dashboard(HttpServletRequest request,
			@RequestParam("unm") String username, @RequestParam("pwd") String pwd) {
		ModelAndView model = new ModelAndView();
		LoginModel user = loginService.getLoginData(username, pwd);
		StudentModel student = studentService.getStudentByUnm(username);
			SessionManager session = new SessionManager();
			if(user != null) {
				List<StudentModel> students = studentService.getAllStudent();
				if(username.equals("admin") && pwd.equals("admin")) {
					model.addObject("role",user.getRole());
					if(students != null) {
						model.addObject("studentDetails", students);
					}
				}else if(username.equals("teacher") && pwd.equals("teacher")) {
					model.addObject("role", user.getRole());
					if(students != null) {
						model.addObject("studentDetails", students);
					}			
				}else if(username.equals(student.getUserName()) && pwd.equals(student.getPassword())) {
					model.addObject("role", user.getRole());
					model.addObject("student", student);
				}
				
			
				session.setLogin(true);
				session.setUser(user);
				HttpSession sessionAtt = request.getSession();
				sessionAtt.setAttribute(IConstants.loginAtt, session);

				model.setViewName("student");
			}else if(student != null){
				
				LoginModel sUser = new LoginModel();
				sUser.setUserName(username);
				sUser.setPassword(pwd);
				sUser.setRole("S");
				sUser.setActive(true);
				loginService.saveLoginData(sUser);
				model.addObject("role", sUser.getRole());
				model.addObject("student", student);
				session.setLogin(true);
				session.setUser(sUser);
				HttpSession sessionAtt = request.getSession();
				sessionAtt.setAttribute(IConstants.loginAtt, session);
				model.setViewName("student");
			}else {
				System.out.println("Invalid login");
				model.addObject("errorMsg", "Invalid login");
				model.setViewName("login");
			}
		return model;
	}
	@GetMapping("logout")
	public ModelAndView LogOut(HttpServletRequest request) {
		ModelAndView model =  new ModelAndView();
		request.getSession().removeAttribute(IConstants.loginAtt);
		SessionManager session = new SessionManager();
		session.setUser(null);
		session.setLogin(false);
		model.setViewName("redirect:/");
		return model;
	}
}
