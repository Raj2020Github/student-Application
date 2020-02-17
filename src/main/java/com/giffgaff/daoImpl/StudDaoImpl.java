package com.giffgaff.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.giffgaff.dao.StudDao;
import com.giffgaff.model.SortByMarks;
import com.giffgaff.model.Student;
import com.giffgaff.serviceImpl.StudServiceImpl;
@Repository
public class StudDaoImpl implements	StudDao{

	@Autowired
	MysqlConnection mysqlConnection;
	
	@Autowired
	StudServiceImpl service;
	
	@Autowired
	Student stud;
	
	
//This method will insert the student details to database
	@Override
	public int insertData(Student student) {
		// TODO Auto-generated method stub
		 int status=0;  
	        try{  
	            Connection conn=mysqlConnection.getConnection();  
	            PreparedStatement ps=conn.prepareStatement(  
	                         "insert into student(name,total_marks) values (?,?)");  
	           // ps.setInt(1, student.getStud_id());
	            ps.setString(1,student.getName());  
	            ps.setString(2,student.getTotal_marks());  
	            status=ps.executeUpdate();  
	              
	            mysqlConnection.closeConnection();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status; 
	}

	
	//This method will fetch data of all students and sort it as per total marks scored in desc order	
	@Override
	public List<Student> fetchData() {
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<Student>();
		
		try {
		Connection conn=mysqlConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from student");  
        ResultSet rs=ps.executeQuery();  		
		
        while(rs.next()) {  
    		Student student = new Student();	
    		student.setStud_id(rs.getInt(1));
    		student.setName(rs.getString(2));
    		student.setTotal_marks(rs.getString(3));
    		
    		studentList.add(student);
    		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
    		}
    		Collections.sort(studentList,new SortByMarks());
			/*
			 * for(int i=0;i<studentList.size();i++) {
			 * System.out.println(studentList.get(i).getName()); }
			 */
    		mysqlConnection.closeConnection();
	}catch(Exception e){ 
		System.out.println(e);
	}
		
		return studentList;
		
	}

	//This method will search the student details in database	
	@Override
	public Student getStudDetail(int id) {
		// TODO Auto-generated method stub
		try {
		Connection conn=mysqlConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement("select * from student where stud_id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  		
				
		while(rs.next()) {  
		stud.setStud_id(rs.getInt(1));
		stud.setName(rs.getString(2));
		stud.setTotal_marks(rs.getString(3));
		
		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		}
		
		service.serializeStudent(stud);
		service.DeseializeStudent();
		mysqlConnection.closeConnection();
		
		}catch(Exception e){ 
			System.out.println(e);
		}
		
		return stud;
	}
	//This method will search the highest score student and serialize the details to file
	@Override
	public Student highestMarksStud() {
		// TODO Auto-generated method stub
		try {
			Connection conn=mysqlConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from student order by total_marks desc limit 1");  
	        ResultSet rs=ps.executeQuery();  		
					
			while(rs.next()) {  
			stud.setStud_id(rs.getInt(1));
			stud.setName(rs.getString(2));
			stud.setTotal_marks(rs.getString(3));
			
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			}
			mysqlConnection.closeConnection();
		}catch(Exception e){ 
			System.out.println(e);
		}
		
		return stud;
	}

}
