package com.giffgaff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.giffgaff.model.Student;


public interface StudService {

	public int insertData(Student student);
	public Student getStudDetail(int id);
	public List<Student> fetchData();
	public Student highestMarksStudent();
	public void serializeStudent(Student student);
	public void DeseializeStudent();
}
