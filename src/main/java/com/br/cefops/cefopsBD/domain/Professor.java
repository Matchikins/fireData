package com.br.cefops.cefopsBD.domain;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor {
	@Id
	Integer Id;
	String Name;
	String LastName;
	Integer Cpf;
	String Email;
	Integer Grupe;
	Integer CourseId;
	boolean isTeacher;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Integer getCpf() {
		return Cpf;
	}
	public void setCpf(Integer cpf) {
		Cpf = cpf;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Integer getGrupe() {
		return Grupe;
	}
	public void setGrupe(Integer grupe) {
		Grupe = grupe;
	}
	public Integer getCourseId() {
		return CourseId;
	}
	public void setCourseId(Integer courseId) {
		CourseId = courseId;
	}
	public boolean isTeacher() {
		return isTeacher;
	}
	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}

}
