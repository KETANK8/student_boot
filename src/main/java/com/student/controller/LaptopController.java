package com.student.controller;

import java.util.List;
import java.util.Optional;

import com.student.model.Laptop;
import com.student.service.LaptopService;

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
@RequestMapping("/laptop")
public class LaptopController {

	@Autowired
	private LaptopService lapService;

	// MAPPING METHOD 1
	// HANDLE REQUEST TO ADD NEW LAPTOP IN DATABASE
	@PostMapping("/add")
	public ResponseEntity<String> addLaptop(@RequestBody Laptop lap) {
		String status = lapService.addLaptop(lap);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// MAPPING METHOD 2
	// HANDLE REQUEST TO FETCH ALL LAPTOP FROM DATABASE
	@GetMapping("/fetch")
	public ResponseEntity<List<Laptop>> getAllLaptop() {
		return new ResponseEntity<>(lapService.getAllLaptop(), HttpStatus.OK);
	}

	// MAPPING METHOD 3
	// HANDLE REQUEST TO FETCH LAPTOP BASED ON PRIMARY KEY
	@GetMapping("/fetch/id/{lapId}")
	public ResponseEntity<Optional<Laptop>> getLaptopById(@PathVariable int lapId) {
		return new ResponseEntity<>(lapService.getLaptopById(lapId), HttpStatus.OK);
	}

	// MAPPING METHOD 4
	// HANDLE REQUEST TO FETCH LAPTOP BASED ON THEIR PRICE
	@GetMapping("/fetch/price/{lapAmount}")
	public ResponseEntity<List<Laptop>> getLaptopByPrice(@PathVariable int lapAmount) {
		return new ResponseEntity<>(lapService.getLaptopByLapAmount(lapAmount), HttpStatus.OK);
	}

	// MAPPING METHOD 5
	// HANDLE REQUEST TO FETCH LAPTOP BASED ON LAPTOP OPERATING SYSTEM
	@GetMapping("/fetch/os/{lapOS}")
	public ResponseEntity<List<Laptop>> getLaptopByOS(@PathVariable String lapOS) {
		return new ResponseEntity<>(lapService.getLaptopByOS(lapOS), HttpStatus.OK);
	}

	// MAPPING METHOD 6
	// HANDLE REQUEST TO FETCH LAPTOPS BASED ON THEIR RAM SIZE
	@GetMapping("/fetch/ram/{lapRAM}")
	public ResponseEntity<List<Laptop>> getLaptopByRam(@PathVariable int lapRAM) {
		return new ResponseEntity<>(lapService.getLaptopByRam(lapRAM), HttpStatus.OK);
	}

	// MAPPING METHOD 7
	// HANDLE REQUEST TO FETCH SORTED DATA OF LAPTOP BASED ON ANY FIELD OF LAPTOP
	@GetMapping("/fetch/sort/{field}")
	public ResponseEntity<List<Laptop>> sortLaptop(@PathVariable String field) {
		return new ResponseEntity<>(lapService.sortLaptop(field), HttpStatus.OK);
	}

	// MAPPING METHOD 8
	// HANDLE REQUEST TO UPDATE THE LAPTOP DATA OF AN EXISTING LAPTOP FROM THE
	// DATABASE
	@PutMapping("/update")
	public ResponseEntity<String> updateLaptop(@RequestBody Laptop lap) {
		String status = lapService.updateLaptop(lap);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// MAPPING METHOD 9
	// HANDLE THE REQUEST TO DELETE LAPTOP FROM DATABASE USING PRIMARY KEY
	@DeleteMapping("/remove/{lapId}")
	public ResponseEntity<String> deleteLaptop(@PathVariable int lapId) {
		String status = lapService.deleteLaptop(lapId);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}