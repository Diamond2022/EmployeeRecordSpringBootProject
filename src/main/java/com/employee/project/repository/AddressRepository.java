package com.employee.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.project.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
