package com.student.repository;

import java.util.List;

import com.student.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByStDomain(String stDomain);

	List<Student> findByStAge(int stAge);

}
