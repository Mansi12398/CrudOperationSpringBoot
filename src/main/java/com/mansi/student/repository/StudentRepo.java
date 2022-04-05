package com.mansi.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mansi.student.model.StudentModel;

@Repository
public interface StudentRepo extends CrudRepository<StudentModel,Integer>{

	
	@Query("select s from StudentModel s where s.userName = :unm AND s.active = true")
	public StudentModel getStudByUnm(@Param("unm") String unm);
	
	@Query("select s from StudentModel s where s.active = true")
	public List<StudentModel> getAllStudents();
}
