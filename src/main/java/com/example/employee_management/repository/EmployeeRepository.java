package com.example.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee_management.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
}
