package com.yf.model;

import java.util.Date;

/**
 * @author —Ó¿ ∑…
 * 
 * "0001", "Jim", "20110705001", "Boy", df.parse("1989-03-26"
 */
public class Student {
	
	private String id;
	
	private String name;
	
	private  String no;
	
	private String gender;
	
	private Date birth;

	public Student(String id, String name, String no, String gender,
			Date birth) {
		this.id = id;
		this.name = name;
		this.no = no;
		this.gender = gender;
		this.birth = birth;
	}

	public Student() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
