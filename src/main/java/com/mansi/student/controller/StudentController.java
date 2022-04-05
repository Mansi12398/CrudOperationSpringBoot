package com.mansi.student.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("addStudent")
	public ModelAndView addStudent(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		model.setViewName("addStudent");
		return model;
	}
	
	@PostMapping("saveStudent")
	public ModelAndView saveStudent(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String pwd =request.getParameter("pwd");
		Integer maths = Integer.parseInt(request.getParameter("maths"));
		Integer english = Integer.parseInt(request.getParameter("english"));
		Integer gujarati = Integer.parseInt(request.getParameter("gujarati"));
		
		int total = maths+english+gujarati;
		double per = (total * 100)/300;
				System.out.println("per : " + per);
		StudentModel student = new StudentModel();
		student.setFirstName(fname);
		student.setLastName(lname);
		student.setUserName(uname);
		student.setPassword(pwd);
		student.setMaths(maths);
		student.setEnglish(english);
		student.setGujarati(gujarati);
		student.setTotal(total);
		student.setPer(per);
		student.setActive(true);
		studentService.saveStudent(student);
		model.setViewName("redirect:home");
		return model;
	}
	
	@GetMapping("home")
	public ModelAndView adminDashboard (HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if(request.getSession().getAttribute(IConstants.loginAtt) != null) {
			SessionManager session = (SessionManager) request.getSession().getAttribute(IConstants.loginAtt);
			if(session != null) {
				System.out.println("session user :: " + session.getUser());
				model.addObject("role", session.getUser().getRole());
			}
			Iterable<StudentModel> stud = studentService.getAllStudent();
			model.addObject("studentDetails", stud);
			model.setViewName("student");
		}else {
			model.setViewName("redirect:/");
		}
		
		return model;
	}
	
	@GetMapping("deleteStudent")
	public ModelAndView deleteStudent (HttpServletRequest request,@RequestParam("id") int id) {
		ModelAndView model = new ModelAndView();
		Optional<StudentModel> stud = studentService.getStudentById(id);
		
		if(stud != null) {
			StudentModel student = stud.get();
			student.setActive(false);
			LoginModel user = loginService.getUserByUnm(student.getUserName());
			if(user != null) {
				user.setActive(false);
				loginService.saveLoginData(user);
			}
			studentService.saveStudent(student);
			
		}
		//studentService.deleteStudById(id);
		model.setViewName("redirect:home");
		return model;
	}
	
	@GetMapping("updateStudent")
	public ModelAndView updateStudent(HttpServletRequest request,@RequestParam("id") int id) {
		ModelAndView model = new ModelAndView();
		Optional<StudentModel> stud = studentService.getStudentById(id);
		model.addObject("stud",stud.get());
		model.setViewName("updateStudent");
		return model;
	}
	
	@PostMapping("updateSaveStudent")
	public ModelAndView updateSaveStudent(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String pwd =request.getParameter("pwd");
		Integer id =Integer.parseInt(request.getParameter("id"));
		Integer maths = Integer.parseInt(request.getParameter("maths"));
		Integer english = Integer.parseInt(request.getParameter("english"));
		Integer gujarati = Integer.parseInt(request.getParameter("gujarati"));
		
		Optional<StudentModel> stud = studentService.getStudentById(id);

		if(stud != null) {
			StudentModel upStud = stud.get();
			int total = maths+english+gujarati;
			double per = (total * 100)/300;
					System.out.println("per : " + per);
			upStud.setFirstName(fname);
			upStud.setLastName(lname);
			upStud.setUserName(uname);
			upStud.setPassword(pwd);
			upStud.setMaths(maths);
			upStud.setEnglish(english);
			upStud.setGujarati(gujarati);
			upStud.setTotal(total);
			upStud.setPer(per);
			
			studentService.saveStudent(upStud);
		}
			
		model.setViewName("redirect:home");
		return model;
	}
}
