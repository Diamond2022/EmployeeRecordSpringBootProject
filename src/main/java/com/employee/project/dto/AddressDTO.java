package com.employee.project.dto;

import lombok.Data;

@Data
public class AddressDTO {
	
	private String addressLineOne;
	private String adressLineTwo;
	private String city;
	private Integer zipCode;
	private String state;
	private String country;
	
	
	public AddressDTO(String addressLineOne, String adressLineTwo, String city, Integer zipCode, String state,
			String country) {
		super();
		this.addressLineOne = addressLineOne;
		this.adressLineTwo = adressLineTwo;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		this.country = country;
	}
	
	public AddressDTO() {
		
	}
	
	
	
	
	
	

}
