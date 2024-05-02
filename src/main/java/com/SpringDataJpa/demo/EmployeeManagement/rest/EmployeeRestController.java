package com.SpringDataJpa.demo.EmployeeManagement.rest;

import com.SpringDataJpa.demo.EmployeeManagement.entity.Employee;
import com.SpringDataJpa.demo.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService= theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Optional<Employee> theEmployee = employeeService.findById(employeeId);
        return theEmployee.orElse(null);
    }


    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbemployee= employeeService.save(theEmployee);
        return dbemployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbemployee= employeeService.save(theEmployee);
        return dbemployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Optional<Employee> theEmployee= employeeService.findById(employeeId);
        employeeService.deleteById(employeeId);
        return "Employee deleted from db";
    }

}
