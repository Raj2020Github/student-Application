package com.giffgaff.model;

import java.util.Comparator;

public class SortByMarks implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return s2.getTotal_marks().compareTo(s1.getTotal_marks());
	}

}
