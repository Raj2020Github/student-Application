package com.giffgaff.serviceImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giffgaff.dao.StudDao;
import com.giffgaff.model.Student;
import com.giffgaff.service.StudService;

@Service
public class StudServiceImpl implements StudService {
	@Autowired
	StudDao studdao;
	
	@Autowired
	Student stud;
	
	@Override
	public int insertData(Student student) {
		int status = studdao.insertData(student);
		return status;
		
	}

	@Override
	public Student getStudDetail(int id) {
		stud = studdao.getStudDetail(id);
		return stud;
		
	}

	@Override
	public List<Student> fetchData() {
		List<Student> studList = new ArrayList<Student>();
		studList = studdao.fetchData();
		return studList;
	}

	@Override
	public Student highestMarksStudent() {
		stud = studdao.highestMarksStud();
		return stud;
	}

	@Override
	public void serializeStudent(Student student) {
		try {
		FileOutputStream fileOutputStream=new FileOutputStream("student.txt");  
		ObjectOutputStream out=new ObjectOutputStream(fileOutputStream);  
		out.writeObject(student);  
		out.flush();  
		out.close();  //closing the stream  
		//System.out.println("success");  
		}catch(Exception e){System.out.println(e);}
	}

	@Override
	public void DeseializeStudent() {
		try{  
			  //Creating stream to read the object  
			  ObjectInputStream in=new ObjectInputStream(new FileInputStream("student.txt"));  
			  Student student=(Student)in.readObject();  
			  //printing the data of the serialized object  
			  //System.out.println(student.getStud_id()+" "+student.getName()+" "+student.getTotal_marks());  
			  //closing the stream  
			  in.close();  
			  }catch(Exception e){System.out.println(e);}  
		
	}

}
