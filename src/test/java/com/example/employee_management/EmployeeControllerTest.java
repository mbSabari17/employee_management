package com.example.employee_management;
import  com.example.employee_management.Employees;
import com.example.employee_management.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
@ExtendWith(SpringExtension.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;

    private Employees employee1;
    private Employees employee2;

    @BeforeEach
    public void setup() {
        employee1 = new Employees(1, "John", "Doe", "Engineering", "Senior", "1234567890", "john.doe@example.com");
        employee2 = new Employees(2, "Jane", "Smith", "HR", "Manager", "0987654321", "jane.smith@example.com");
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2));

        mockMvc.perform(get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", is("John")));
    }

    @Test
    public void testGetEmployeeById() throws Exception {
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee1));

        mockMvc.perform(get("/employees/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("John")));
    }

//    @Test
//    public void testCreateEmployee() throws Exception {
//        Employees newEmployee = new Employees(null, "Alice", "Johnson", "Marketing", "Junior", "5551234567", "alice.johnson@example.com");
//        when(employeeRepository.save(any(Employees.class))).thenReturn(newEmployee);
//
//        String employeeJson = "{ \"firstName\": \"Alice\", \"lastName\": \"Johnson\", \"department\": \"Marketing\", \"position\": \"Junior\", \"phone\": \"5551234567\", \"email\": \"alice.johnson@example.com\" }";

//        mockMvc.perform(post("/employees")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(employeeJson))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.firstName", is("Alice")));
 //   }

//    @Test
//    public void testUpdateEmployee() throws Exception {
//        Employees updatedEmployee = new Employees(1, "John", "Doe", "Engineering", "Lead", "1234567890", "john.doe@example.com");
//        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee1));
//        when(employeeRepository.save(any(Employees.class))).thenReturn(updatedEmployee);
//
//        String employeeJson = "{ \"firstName\": \"John\", \"lastName\": \"Doe\", \"department\": \"Engineering\", \"position\": \"Lead\", \"phone\": \"1234567890\", \"email\": \"john.doe@example.com\" }";
//
//        mockMvc.perform(put("/employees/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(employeeJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.position", is("Lead")));
//    }

    @Test
    public void testDeleteEmployee() throws Exception {
        when(employeeRepository.existsById(1)).thenReturn(true);
        doNothing().when(employeeRepository).deleteById(1);

        mockMvc.perform(delete("/employees/1"))
                .andExpect(status().isNoContent());
    }
}

