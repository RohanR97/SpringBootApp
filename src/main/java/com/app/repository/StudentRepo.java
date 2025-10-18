package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Student;

@Repository
public interface StudentRepo  extends JpaRepository<Student, Integer> {
	
	
	public List<Student> findByLocation(String location);
	public List<Student> findByLocationOrMarks(String location, int marks);
//	public void deleteByLocation(String location);
	public List<Student> deleteByLocation(String location);
	
	
	

}
