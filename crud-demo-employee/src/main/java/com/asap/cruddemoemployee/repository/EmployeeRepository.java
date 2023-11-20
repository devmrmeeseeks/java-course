package com.asap.cruddemoemployee.repository;

import com.asap.cruddemoemployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
