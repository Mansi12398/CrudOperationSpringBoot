package com.mansi.student.service;

import java.util.List;
import java.util.Optional;

import com.mansi.student.model.StudentModel;

public interface StudentService {

	void saveStudent(StudentModel student);
	
	List<StudentModel> getAllStudent();
	
	StudentModel getStudentByUnm(String unm);
	
	void deleteStudById(int id);
	
	 Optional<StudentModel> getStudentById(int id);
}
