package com.br.cefops.cefopsBD.domain;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Curso {
	@Id
	Integer Id;
	String Name;
	String Link;
	Integer teacherID;
	boolean isOnline;
	
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
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
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public Integer getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(Integer teacherID) {
		this.teacherID = teacherID;
	}

	
	
	
}
