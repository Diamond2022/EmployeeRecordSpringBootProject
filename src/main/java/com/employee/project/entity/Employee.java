package com.employee.project.entity;

import java.time.LocalDate;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "employee")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	private String fName;
	private String lName;
	private LocalDate dob;
	private Double salary;
	private String position;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id",  referencedColumnName = "id")
	private Address address;
	
	
	
	

	public Employee() {
		
	}





	public Employee(Long empId, String fName, String lName, LocalDate dob, Double salary, String position,
			Address address) {
		super();
		this.empId = empId;
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.salary = salary;
		this.position = position;
		this.address = address;
	}
	
	
	
	
	 

}
