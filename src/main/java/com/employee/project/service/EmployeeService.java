package com.employee.project.service;

import java.util.List;

import com.employee.project.dto.EmployeeDTO;

public interface EmployeeService {
	EmployeeDTO saveEmployee(EmployeeDTO employeedto);
	EmployeeDTO getEmployeeById(Long empId);
	EmployeeDTO updateEmployee(Long empId, EmployeeDTO employeedto);
	List<EmployeeDTO> searchEmployees(Long empId, String fName, String lName, String city, String state, String country);
	void deleteEmployeeById(Long empId); 
	
	
	
	
	

}
