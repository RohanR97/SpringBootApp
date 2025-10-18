package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.model.Student;
import com.app.repository.StudentRepo;

import jakarta.transaction.Transactional;

@Service
public class StudentService  implements StudentServiceInt {
	
	@Autowired
	StudentRepo sr;

	@Override
	public void addStudent(Student student) {
		
		sr.save(student);
		
	}

	@Override
	public List<Student> getallStudent() {
		List<Student> list = sr.findAll();
		return list;
	}

	@Override
	public Student updateStudent(Student student) {
		Student stu = sr.save(student);
		return stu;
	}

	@Override
	public Student updateStudetnRoll(int rn) {
		Optional<Student> op = sr.findById(rn);
		Student student = op.get();
		student.setLocation("raigad");
		
		sr.save(student);
		
		return student;
	}

	@Override
	public List<Student> deleteStudent(int rollno) {
		sr.deleteById(rollno);
		List<Student> list = sr.findAll();
		return list;
	}

	@Override
	public List<Student> addListOfdStudent(List<Student> list) {
		List<Student> saveAll = sr.saveAll(list);
		
		return saveAll;
	}

	@Override
	public List<Student> getlocaionData(String location) {
	
		List<Student> list = sr.findByLocation(location);
		return list;
	}

	@Override
	public List<Student> getBymarksandlocation(String location, int marks) {
		
		List<Student> list = sr.findByLocationOrMarks(location, marks);
		
		return list;
	}

	@Override
	@Transactional
	@Modifying
	public List<Student> deleteStudentByItsLocation(String location) {
		 List<Student> list = sr.deleteByLocation(location);
//		List<Student> all = sr.findAll();
		return list;
	}

	@Override
	public String deleteAllStudent() {
		  sr.deleteAll();
		return "All DATA DELETED SUCCESFULLY";
	}
	
	
	

	
	

}
