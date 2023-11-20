package com.asap.cruddemoemployee.rest;

import com.asap.cruddemoemployee.entity.Employee;
import com.asap.cruddemoemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public int save(@RequestBody Employee newEmployee) {
        Employee employee = employeeService.save(newEmployee);
        return employee.getId();
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee id not found: " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee with id: " + employeeId;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
