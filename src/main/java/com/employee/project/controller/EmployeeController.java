package com.employee.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.project.dto.EmployeeDTO;
import com.employee.project.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeedto) {
		return employeeService.saveEmployee(employeedto);
	}
	
	@GetMapping("/{empId}")
	public EmployeeDTO getEmployeeById(@PathVariable Long empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@PutMapping("/{empId}")
	public EmployeeDTO updateEmployee(@PathVariable Long empId, @RequestBody EmployeeDTO employeedto) {
		return employeeService.updateEmployee(empId, employeedto);
	}
	
	@DeleteMapping("/{empId}")
	public void deleteEmployee(@PathVariable Long empId) {
		 System.out.println("Deleting employee with ID: " + empId);
		employeeService.deleteEmployeeById(empId);
	}
	

	
	@GetMapping("/searchEmployees")
	public List<EmployeeDTO> searchEmployee( 
			@RequestParam(required = false) Long empId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String country){
		return employeeService.searchEmployees(empId, firstName, lastName, city, state, country);
		
	}
	
}
