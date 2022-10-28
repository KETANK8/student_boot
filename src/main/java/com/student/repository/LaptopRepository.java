package com.student.repository;

import java.util.List;

import com.student.model.Laptop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

	List<Laptop> findByLapOS(String lapOS);

	List<Laptop> findByLapAmount(int lapPrice);

	List<Laptop> findByLapRAM(int lapRAM);

}
