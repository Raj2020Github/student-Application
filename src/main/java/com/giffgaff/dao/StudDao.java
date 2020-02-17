package com.giffgaff.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.giffgaff.model.Student;


public interface StudDao {

	public int insertData(Student student);//This method will insert the student details to database

	public List<Student> fetchData();	//This method will fetch data of all students and sort it as per total marks scored in desc order	

	public Student getStudDetail(int id);	//This method will search the student details in database	

	public Student highestMarksStud(); 	//This method will search the highest score student and serialize the details to file

}
