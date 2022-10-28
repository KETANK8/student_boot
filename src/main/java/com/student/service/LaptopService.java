package com.student.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.student.model.Laptop;
import com.student.repository.LaptopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

	@Autowired
	private LaptopRepository lapRepo;

	// METHOD 1
	// ADD NEW LAPTOP IN DATABASE
	public String addLaptop(Laptop lap) {

		Laptop _lap = lapRepo.save(lap);
		if (_lap != null)
			return "Laptop added @" + new Date();
		else
			return null;
	}

	// METHOD 2
	// RETRIVE THE LIST OF ALL LAPTOP FROM DB
	public List<Laptop> getAllLaptop() {
		return lapRepo.findAll();
	}

	// METHOD 3
	// RETRIVE A LAPTOP USING PRIMARY KEY
	public Optional<Laptop> getLaptopById(int lapId) {
		return lapRepo.findById(lapId);
	}

	// METHOD 4
	// RETRIVE LIST OF LAPTOP WITH SAME OPERATING SYSTEM
	public List<Laptop> getLaptopByOS(String lapOS) {
		return lapRepo.findByLapOS(lapOS);
	}

	// METHOD 5
	// RETRIVE LIST OF LAPTOP OF SAME PRICE
	public List<Laptop> getLaptopByLapAmount(int lapPrice) {
		return lapRepo.findByLapAmount(lapPrice);
	}

	// METHOD 6
	// RETRIVE LIST OF LAPTOP WITH SAME RAM SIZE
	public List<Laptop> getLaptopByRam(int lapRAM) {
		return lapRepo.findByLapRAM(lapRAM);
	}

	// METHOD 7
	// UPDATE AN EXISTING LAPTOP WITH NEW DATA IN DB
	public String updateLaptop(Laptop lap) {
		Laptop _lap = lapRepo.save(lap);
		if (_lap != null)
			return "Laptop updated " + new Date();
		else
			return null;
	}

	// METHOD 8
	// DELETE A LAPTOP FROM DB USING PRIMARY KEY
	public String deleteLaptop(int lapId) {
		Optional<Laptop> _lap = lapRepo.findById(lapId);
		if (_lap != null) {
			lapRepo.deleteById(lapId);
			return "Laptop Deleted";
		} else
			return null;
	}

	// METHOD 9
	// RETRIVE SORTED LIST OF LAPTOP BASED ON GIVEN ATTRIBUTE
	public List<Laptop> sortLaptop(String fields) {
		return lapRepo.findAll(Sort.by(Direction.DESC, fields));
	}
}
