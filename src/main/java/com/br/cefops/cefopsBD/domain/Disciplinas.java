package com.br.cefops.cefopsBD.domain;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disciplinas {
	@Id
	Integer Id;
	String Name;
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

}
