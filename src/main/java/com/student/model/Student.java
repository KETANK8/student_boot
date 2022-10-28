package com.student.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stId;
	private String stFirstName;
	private String stLastName;
	private String stDomain;
	private String stEmail;
	private String stContact;
	private int stAge;
	@OneToMany
	@JoinColumn(name = "stId_lapId")
	private List<Laptop> lapList;

}
