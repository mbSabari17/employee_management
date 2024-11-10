package com.example.employee_management;

import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository EmployeeRepository;

    public EmployeeController(EmployeeRepository EmployeeRepository) {
        this.EmployeeRepository = EmployeeRepository;
    }

    // GET /employees
    @GetMapping
    public ResponseEntity<List<Employees>> getEmployees() {
        List<Employees> employees = EmployeeRepository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // POST /employees
    @PostMapping
    public ResponseEntity<Employees> createEmployee(@RequestBody Employees employee) {
        Employees savedEmployee = EmployeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // GET /employees/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable Integer id) {
        Optional<Employees> employee = EmployeeRepository.findById(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // PUT /employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable Integer id, @RequestBody Employees employeeDetails) {
        Optional<Employees> optionalEmployee = EmployeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employees employee = optionalEmployee.get();
            // Update employee details
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setPosition(employeeDetails.getPosition());
            employee.setPhone(employeeDetails.getPhone());
            employee.setEmail(employeeDetails.getEmail());
            Employees updatedEmployee = EmployeeRepository.save(employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /employees/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        if (EmployeeRepository.existsById(id)) {
            EmployeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}