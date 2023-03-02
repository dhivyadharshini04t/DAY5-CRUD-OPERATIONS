package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Family")
public class StudentModel {
	@Id

	@Column(name="age")
	private int age;
	@Column(name="relation")
	private String relation;
	@Column(name="name")
	private String name;
	public StudentModel(int age, String relation,String name) {
		super();
		this.age = age;
		this.relation = relation;
		this.name = name;
		
	}
	public StudentModel() {
		
	}
	
	public int getage(){
		return age;
	}
	public void setid(int age) {
		this.age = age;
	}
	public String getrelation() {
		return relation;
	}
	public void setrelation(String relation) {
		this.relation = relation;
	}
	public String getname() {
		return name ;
	}
	public void setname(String name) {
		this.name= name;
		
	}
	
	
	public String toString() {
		return "age="+age+"relation="+relation+"name="+name;
	}
}