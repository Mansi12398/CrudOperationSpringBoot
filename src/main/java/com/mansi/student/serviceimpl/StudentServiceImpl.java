package com.mansi.student.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mansi.student.model.StudentModel;
import com.mansi.student.repository.StudentRepo;
import com.mansi.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public void saveStudent(StudentModel student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
	}

	@Override
	public List<StudentModel> getAllStudent() {
		// TODO Auto-generated method stub
		//return studentRepo.findAll();
		return studentRepo.getAllStudents();
	}

	@Override
	public StudentModel getStudentByUnm(String unm) {
		// TODO Auto-generated method stub
		System.out.println("SResult = "+studentRepo.getStudByUnm(unm));
		return studentRepo.getStudByUnm(unm);
	}

	@Override
	public void deleteStudById(int id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
	}

	@Override
	public Optional<StudentModel> getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id);
	}

}
