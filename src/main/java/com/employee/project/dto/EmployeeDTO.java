package com.employee.project.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;



@Data
public class EmployeeDTO {
	
	@JsonProperty("empId")
	private Long empId;
	
	@JsonProperty("fname")
	private String fName;
	
	@JsonProperty("lname")
	private String lName;
	
	@JsonProperty("dob")
	private LocalDate dob;
	
	@JsonProperty("salary")
	private Double salary;
	
	@JsonProperty("position")
	private String position;
	
	private AddressDTO address;
	
	


	public EmployeeDTO(Long empId, String fName, String lName, LocalDate dob, Double salary, String position,
			AddressDTO address) {
		super();
		this.empId = empId;
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.salary = salary;
		this.position = position;
		this.address = address;
	} 
	
	public EmployeeDTO() {}
	
	
	
	
	
	

	
	
	
	
	

}
