package com.giffgaff.model;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Student implements Serializable {

	private int stud_id;
	private String name;
	private String total_marks;
	
	
	public int getStud_id() {
		return stud_id;
	}
	
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(String total_marks) {
		this.total_marks = total_marks;
	}
}
