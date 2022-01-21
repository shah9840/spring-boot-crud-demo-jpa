package com.shahabaaz.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shahabaaz.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
