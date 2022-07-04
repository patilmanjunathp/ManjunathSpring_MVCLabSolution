package com.greatlearning.studentmanagement.service;

import java.util.List;

import com.greatlearning.studentmanagement.model.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student findById(long studenId);

	public void save(Student student);

	public void delete(long studentId);

}
