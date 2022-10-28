package com.student.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.student.model.Student;
import com.student.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository stdRepo;

	// METHOD 1
	// ADD NEW STUDENT IN DB
	public String addStudent(Student std) {
		Student _std = stdRepo.save(std);
		if (_std != null)
			return "Student added @" + new Date();
		else
			return null;
	}

	// METHOD 2
	// RETRIVE LIST OF ALL STUDENT FROM DB
	public List<Student> getAllStudent() {

		return stdRepo.findAll();
	}

	// METHOD 3
	// RETRIVE A STUDENT FROM DB USING PRIMARY KEY
	public Optional<Student> getStudentById(int stId) {
		return stdRepo.findById(stId);
	}

	// METHOD 4
	// RETRIVE LIST OF STUDENT WITH SAME DOMAIN
	public List<Student> getStudentByDomain(String stDomain) {
		return stdRepo.findByStDomain(stDomain);
	}

	// METHOD 5
	// RETRIVE LIST OF STUDENT OF SAME AGE
	public List<Student> getStudentByAge(int stAge) {
		return stdRepo.findByStAge(stAge);
	}

	// METHOD 6
	// UPDATE THE DETAILS OF EXISTING STUDENT WITH NEW DATA IN DB
	public String updateStudent(Student std) {
		Student _std = stdRepo.save(std);
		if (_std != null)
			return "Student Updated @" + new Date();
		else
			return null;
	}

	// METHOD 7
	// DELETE A STUDENT FROM DATABASE USING PRIMARY KEY
	public String deleteStudent(int stId) {
		Optional<Student> _std = stdRepo.findById(stId);
		if (_std != null) {
			stdRepo.deleteById(stId);
			return "Student Deleted @" + new Date();
		} else
			return null;
	}

	// METHOD 8
	// RETRIVE SORTED LIST OF STUDENT BASED ON GIVEN ATTRIBUTE
	public List<Student> sortStudent(String fields) {
		return stdRepo.findAll(Sort.by(Direction.DESC, fields));
	}
}
