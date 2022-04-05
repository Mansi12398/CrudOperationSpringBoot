package com.mansi.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_studentinfo")
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "student")
	@Column(name = "stud_id")
	private int studentId;

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "maths")
	private int maths;
	@Column(name = "english")
	private int english;
	@Column(name = "gujarati")
	private int gujarati;
	@Column(name = "total")
	private int total;
	@Column(name = "per")
	private double per;
	
	@Column(name="active" , columnDefinition="boolean default true")
	private boolean active;
	
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getGujarati() {
		return gujarati;
	}
	public void setGujarati(int gujarati) {
		this.gujarati = gujarati;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}

	
	
}
