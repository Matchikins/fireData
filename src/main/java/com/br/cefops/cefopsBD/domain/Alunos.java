package com.br.cefops.cefopsBD.domain;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Alunos {
	@Id
	Integer Id;
	String Name;
	String LastName;
	long  Cpf;
	String Email;
	Integer Grupe;
	Integer CourseId;
	Integer teacherID;
	
	@ManyToOne
	private Curso curso;
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
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
	public double getCpf() {
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
	public Integer getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}

}
