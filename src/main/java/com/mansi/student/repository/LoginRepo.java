package com.mansi.student.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mansi.student.model.LoginModel;

@Repository
public interface LoginRepo extends CrudRepository<LoginModel, Integer>{

	@Query("select l from LoginModel l where l.userName = :username AND l.password = :pwd AND l.active = true")
	public LoginModel getUserByNamePwd(@Param("username")String username,@Param("pwd")String pwd);
	
	@Query("select l from LoginModel l where l.userName = :username")
	public LoginModel getUserByUnm(@Param("username")String username);
}
