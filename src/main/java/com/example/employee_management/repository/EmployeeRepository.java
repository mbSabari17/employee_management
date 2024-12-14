package com.example.employee_management.repository;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee_management.Employees;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
    List<Employees> findByDepartment(String department);
    List<Employees> findByDepartmentAndPosition(String department, String position);
    @Query("SELECT e.department AS department, COUNT(e) AS count FROM Employees e GROUP BY e.department")
    List<Map<String, Integer>>  countByDepartment();


}
