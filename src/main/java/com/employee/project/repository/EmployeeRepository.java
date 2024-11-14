package com.employee.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.project.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
//	 @Query("SELECT e FROM Employee e JOIN e.address a WHERE " +
//	           "(:empId IS NOT NULL OR e.empId = :empId) AND " +
//	           "(:fName IS NULL OR e.fName LIKE %:fName%) AND " +
//	           "(:lName IS NULL OR e.lName LIKE %:lName%) AND " +
//	           "(:city IS NULL OR a.city LIKE %:city%) AND " +
//	           "(:state IS NULL OR a.state LIKE %:state%) AND " +
//	           "(:country IS NULL OR a.country LIKE %:country%)")
	
	@Query("SELECT e FROM Employee e JOIN e.address a WHERE " +
	           "(:empId IS NULL OR e.empId = :empId) AND " +
	           "(:fName IS NULL OR LOWER(e.fName) LIKE LOWER(CONCAT('%', :fName, '%'))) AND " +
	           "(:lName IS NULL OR LOWER(e.lName) LIKE LOWER(CONCAT('%', :lName, '%'))) AND " +
	           "(:city IS NULL OR LOWER(a.city) LIKE LOWER(CONCAT('%', :city, '%'))) AND " +
	           "(:state IS NULL OR LOWER(a.state) LIKE LOWER(CONCAT('%', :state, '%'))) AND " +
	           "(:country IS NULL OR LOWER(a.country) LIKE LOWER(CONCAT('%', :country, '%')))")
	    
	List<Employee> searchEmployees(
	            @Param("empId") Long empId,
	            @Param("fName") String firstName,
	            @Param("lName") String lastName,
	            @Param("city") String city,
	            @Param("state") String state,
	            @Param("country") String country);

	
	}
