package com.app.service;

import java.util.List;

import com.app.model.Student;

public interface StudentServiceInt {
	
	
	public void addStudent(Student student);

	public List<Student> getallStudent();

	public Student updateStudent(Student student);

	public Student updateStudetnRoll(int rn);

	public List<Student> deleteStudent(int rollno);

	public List<Student> addListOfdStudent(List<Student> list);

	public List<Student> getlocaionData(String location);

	public List<Student> getBymarksandlocation(String location, int marks);

	public List<Student> deleteStudentByItsLocation(String location);

	public String deleteAllStudent();

}
