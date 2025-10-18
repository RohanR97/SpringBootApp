package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Student;
import com.app.service.StudentServiceInt;

@RestController
public class StudentController {
	
	@Autowired
	StudentServiceInt ssi;
	
	@PostMapping("addList")
	public List<Student> saveListOfStudent(@RequestBody List<Student> list)
	{
		List<Student> li = ssi.addListOfdStudent(list);
		
		return li;
		
	}

	@PostMapping("/add")
	public void registerStudent(@RequestBody Student student)
	{
		ssi.addStudent(student);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudent()
	{
		    List<Student> list = ssi.getallStudent();
		    
		    return list;
	}
	
	
	@PutMapping("update")
	public Student updateStudent(@RequestBody Student student)
	{
		Student stu = ssi.updateStudent(student);
		return stu;
	}
	
	@PutMapping("/byRoll/{rollno}")
	public Student updateStudetnRoll(@PathVariable("rollno") int rn)
	{
//		System.out.println(rn);
		Student s = ssi.updateStudetnRoll(rn);
		
		
		return s;
	}
	
	@DeleteMapping("/del/{rollno}")
	public List<Student> deleteStudent(@PathVariable int rollno)
	{
		
//		System.out.println(rollno);
		
		List<Student> list = ssi.deleteStudent(rollno);
		
		
		return list;
	}
	
	@GetMapping("searchByLocation/{location}")
	public List<Student> getLocationData(@PathVariable String location)
	{
		List<Student> li = ssi.getlocaionData(location);
		
		return li;
	}
	
	@GetMapping("mul/{location}/{marks}")
	public List<Student> getBymarksandlocation(@PathVariable String location, @PathVariable int marks)
	{
		
		System.out.println(location +"  "+ marks);
		
		List<Student> li = ssi.getBymarksandlocation(location, marks);
		
		return li;
		
	}
	
	
	@DeleteMapping("/delLoc/{location}")
	public List<Student> deleteStudentByItsLocation(@PathVariable String location)
	{
		List<Student> li = ssi.deleteStudentByItsLocation(location);
		
		return li;
//		System.out.println(location);
//		return null;
		
	}
	
	@DeleteMapping("delall")
	public String deleteAllStudent()
	{
		String s = ssi.deleteAllStudent();
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
