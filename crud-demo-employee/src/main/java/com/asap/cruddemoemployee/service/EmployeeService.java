package com.asap.cruddemoemployee.service;

import com.asap.cruddemoemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
