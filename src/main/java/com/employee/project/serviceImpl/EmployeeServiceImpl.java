package com.employee.project.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.project.dto.AddressDTO;
import com.employee.project.dto.EmployeeDTO;
import com.employee.project.entity.Address;
import com.employee.project.entity.Employee;
import com.employee.project.repository.EmployeeRepository;
import com.employee.project.service.EmployeeService;



@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	
	
	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeedto) {
		Employee employee = convetToEntity(employeedto);
		employee.setFName(employeedto.getFName());
		employee.setLName(employeedto.getLName());
		employee.setDob(employeedto.getDob());
		employee.setPosition(employeedto.getPosition());
		employee.setSalary(employeedto.getSalary());
		Employee saveEmployee =employeeRepository.save(employee);
		
		return convertToDTO(saveEmployee);
	}
	
	@Override
	public EmployeeDTO getEmployeeById(Long empId) {
		Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
		
		return convertToDTO(employee);
	}

	@Override
	public EmployeeDTO updateEmployee(Long empId, EmployeeDTO employeedto) {
		Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
		employee.setFName(employeedto.getFName());
		employee.setLName(employeedto.getLName());
		employee.setDob(employeedto.getDob());
		employee.setPosition(employeedto.getPosition());
		employee.setSalary(employeedto.getSalary());
		
		Employee updateEmployee = employeeRepository.save(employee);
		return convertToDTO(updateEmployee);
	}

	@Override
	public List<EmployeeDTO> searchEmployees(Long empId, String fName, String lName, String city, String state, String country) {
		List<Employee> employees =employeeRepository.searchEmployees(empId, fName, lName, city, state, country);
		
		return employees.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public void deleteEmployeeById(Long empId) {
		 employeeRepository.deleteById(empId);
		
	}
	
	
	
	
	private Employee convetToEntity(EmployeeDTO employeedto) {
		Employee employee= new Employee();
		employee.setEmpId(employeedto.getEmpId());
	    employee.setFName(employeedto.getFName());
	    employee.setLName(employeedto.getLName());
	    employee.setAddress(convertToEntity(employeedto.getAddress()));
	    
	    return employee;
	}
	
	private Address convertToEntity(AddressDTO addressdto) {
		Address address = new Address();
		address.setAddressLineOne(addressdto.getAddressLineOne());
		address.setAdressLineTwo(addressdto.getAdressLineTwo());
		address.setCity(addressdto.getCity());
		address.setZipCode(addressdto.getZipCode());
		address.setState(addressdto.getState());
		address.setCountry(addressdto.getCountry());
		
		return address;
	}
	
	private EmployeeDTO convertToDTO(Employee employee) {
		EmployeeDTO employeedto = new EmployeeDTO();
		employeedto.setEmpId(employee.getEmpId());
		employeedto.setFName(employee.getFName());
		employeedto.setLName(employee.getLName());
		employeedto.setDob(employee.getDob());
		employeedto.setPosition(employee.getPosition());
		employeedto.setSalary(employee.getSalary());
		employeedto.setAddress(convertToDTO(employee.getAddress()));
		
		return employeedto;
	}
	
	private AddressDTO convertToDTO(Address address) {
		AddressDTO addressdto = new AddressDTO();
		addressdto.setAddressLineOne(address.getAddressLineOne());
		addressdto.setAdressLineTwo(address.getAdressLineTwo());
		addressdto.setCity(address.getCity());
		addressdto.setZipCode(address.getZipCode());
		addressdto.setState(address.getState());
		addressdto.setCountry(address.getCountry());
		
		return addressdto;
	}

	

}
