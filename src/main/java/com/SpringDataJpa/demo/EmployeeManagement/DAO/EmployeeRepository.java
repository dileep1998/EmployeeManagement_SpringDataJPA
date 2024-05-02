package com.SpringDataJpa.demo.EmployeeManagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SpringDataJpa.demo.EmployeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
