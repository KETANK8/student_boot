package com.student.controller;

import java.util.List;
import java.util.Optional;

import com.student.model.Student;
import com.student.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService stdService;

	// MAPPING METHOD 1
	// TO HANDLE REQUEST TO ADD NEW STUDENT IN DATABASE
	@PostMapping("/add")
	public ResponseEntity<String> addStudent(@RequestBody Student std) {
		String status = stdService.addStudent(std);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// MAPPING METHOD 2
	// TO HANDLE REQUEST TO FETCH ALL STUDENT IN DATABASE
	@GetMapping("/fetch/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<>(stdService.getAllStudent(), HttpStatus.OK);
	}

	// MAPPING METHOD 3
	// TO HANDLE REQUEST TO FETCH STUDENT DETAIL BASED ON STUDENT ID
	@GetMapping("/fetch/id/{stId}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable int stId) {
		return new ResponseEntity<>(stdService.getStudentById(stId), HttpStatus.OK);
	}

	// MAPPING METHOD 4
	// HANDLE REQUEST TO FETCH STUDENT DATA BASED ON STUDENT DOMAIN
	@GetMapping("/fetch/domain/{stDomain}")
	public ResponseEntity<List<Student>> getStudentByDomain(@PathVariable String stDomain) {
		return new ResponseEntity<>(stdService.getStudentByDomain(stDomain), HttpStatus.OK);
	}

	// MAPPING METHOD 5
	// HANDLE REQUEST TO FETCH STUDENT DATA BASED ON STUDENT AGE
	@GetMapping("/fetch/age/{stAge}")
	public ResponseEntity<List<Student>> getStudentByAge(@PathVariable int stAge) {
		return new ResponseEntity<>(stdService.getStudentByAge(stAge), HttpStatus.OK);
	}

	// MAPPING METHOD 6
	// HANLE REQUEST TO UPDATE STUDENT DATA IN DATABASE
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student std) {
		String status = stdService.updateStudent(std);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// MAPPING METHOD 7
	// HANDLE REQUEST TO DELETE STUDENT DATA FROM DATABASE USING PRIMARY KEY
	@DeleteMapping("/remove/{stId}")
	public ResponseEntity<String> deleteStudent(@PathVariable int stId) {
		String status = stdService.deleteStudent(stId);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// MAPPING METHOD 8
	// HANDLE REQUEST TO SORT THE STUDENT USING ANY COLUMN DATA
	@GetMapping("/fetch/sort/{field}")
	public ResponseEntity<List<Student>> sortStudent(@PathVariable String field) {
		return new ResponseEntity<>(stdService.sortStudent(field), HttpStatus.OK);
	}
}
