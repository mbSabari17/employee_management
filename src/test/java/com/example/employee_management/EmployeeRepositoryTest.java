package com.example.employee_management;

import com.example.employee_management.Employees;
import com.example.employee_management.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employees employee1;
    private Employees employee2;

    @BeforeEach
    public void setup() {
        employee1 = new Employees(null, "John", "Doe", "Engineering", "Senior", "1234567890", "john.doe@example.com");
        employee2 = new Employees(null, "Jane", "Smith", "HR", "Manager", "0987654321", "jane.smith@example.com");
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }

    @Test
    public void testFindAll() {
        List<Employees> employees = employeeRepository.findAll();
        assertEquals(2, employees.size());
    }

    @Test
    public void testFindById() {
        Optional<Employees> employee = employeeRepository.findById(employee1.getId());
        assertTrue(employee.isPresent());
        assertEquals("John", employee.get().getFirstName());
    }

    @Test
    public void testSave() {
        Employees employee = new Employees
                (null, "Alice", "Johnson", "Marketing", "Junior", "5551234567", "alice.johnson@example.com");
        Employees savedEmployee = employeeRepository.save(employee);
        assertNotNull(savedEmployee.getId());
        assertEquals("Alice", savedEmployee.getFirstName());
    }

    @Test
    public void testDeleteById() {
        employeeRepository.deleteById(employee1.getId());
        Optional<Employees> employee = employeeRepository.findById(employee1.getId());
        assertFalse(employee.isPresent());
    }
}



