package com.example.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee_management.Employees;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
    List<Employees> findByDepartment(String department);
    List<Employees> findByDepartmentAndPosition(String department, String position);
}
