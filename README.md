# Employee Management
## Employee Management Architecture Diagram

### Overview
This UML diagram encapsulates the architecture of the Employee Management API, illustrating how employee data is structured and managed through services and controllers, promoting organized data handling.

### Key Classes
1. **Employee**
   - Represents an employee with attributes like `id`, `firstName`, `lastName`, `department`, `position`, `phone`, and `email`.
   - Includes getter and setter methods for each attribute.

2. **EmployeeService**
   - Provides methods for managing employees, such as retrieving the list of employees, creating new employees, and updating or deleting existing ones.

3. **EmployeeController**
   - Acts as the interface for handling HTTP requests, invoking methods from the `EmployeeService` to perform operations on employee data.
     
![Architecture_Diagram](https://github.com/mbSabari17/employee_details/blob/2163898f9d2419c83fe1c6dabf7e83241aadf339/docs/architecture_diagram.drawio.png?raw=true)

## Employee Management API Design

### Overview

This API streamlines the management of employee records, providing essential functionality for data manipulation and ensuring structured operations.

#### Servers
Production:[SwaggerHub API Auto Mocking]

Development:http://localhost:8080/api/v1


#### Endpoints Overview
1. **GET /employees**: Retrieve a list of employees.  
   - **Responses:** 200 (Success), 500 (Internal Server Error).

2. **POST /employees**: Create a new employee.  
   - **Request Body:** Employee object required.  
   - **Responses:** 201 (Created), 400 (Bad Request), 500 (Internal Server Error).

3. **GET /employees/{id}**: Retrieve an employee by ID.  
   - **Parameters:** `id` (integer, required).  
   - **Responses:** 200 (Success), 404 (Not Found), 500 (Internal Server Error).

4. **PUT /employees/{id}**: Update an employee's details.  
   - **Parameters:** `id` (integer, required).  
   - **Request Body:** Employee object required.  
   - **Responses:** 200 (Success), 400 (Bad Request), 404 (Not Found), 500 (Internal Server Error).

5. **DELETE /employees/{id}**: Delete an employee.  
   - **Parameters:** `id` (integer, required).  
   - **Responses:** 204 (No Content), 404 (Not Found), 500 (Internal Server Error).

#### Employee Schema
- **Properties:**

| Property    | Type     | Description                               |
|-------------|----------|-------------------------------------------|
| `id`        | Integer  | Unique identifier for the employee       |
| `firstName` | String   | Employee's first name                    |
| `lastName`  | String   | Employee's last name                     |
| `department`| String   | Department (HR, Engineering, Sales, Marketing, Finance) |
| `position`  | String   | Job title (Manager, Senior, Junior, Intern) |
| `phone`     | String   | Phone number                             |
| `email`     | String   | Email address (format: email)           |

- ### Link -
https://github.com/mbSabari17/employee_management/blob/b87ecf01c6995baddc332d2a990b060ba40f0318/api/employee_management.yaml

## Test Cases for Employee Management API

#### Summary
These test cases provide a comprehensive approach to validating the core functionalities of the Employee Management API, contributing to reliable and effective management of employee data.

#### Test Scenarios
1. **Retrieve Employee Data**
   - Verify the ability to fetch a list of employees and individual employee details using valid, non-existent, and invalid IDs.

2. **Create Employee Records**
   - Test successful creation of new employee records and ensure appropriate error handling for invalid input.

3. **Update Employee Information**
   - Assess the API's capability to update existing employee details, including validation for invalid inputs and handling attempts to update non-existent records.

4. **Delete Employee Records**
   - Confirm successful deletion of employee records while ensuring proper error responses for non-existent IDs.
   - 
### Expected Outcomes
- The API should return appropriate status codes (200, 201, 204, 400, 404, 500) based on the actions performed.
- Responses should include relevant messages to indicate success or the nature of any errors encountered.
- The API must maintain data integrity, ensuring accurate retrieval, creation, updating, and deletion of employee records.

- ### Link -
- https://github.com/mbSabari17/employee_management/blob/b87ecf01c6995baddc332d2a990b060ba40f0318/src/test/java/com/example/employee_management/feature/TestCase.feature

## Database Schema for Employee Management

### Summary
This schema supports the functionality of the Employee Management API, facilitating efficient management of employee data.

### Employee Table Schema
 **Table Name:** `employees`

| Column Name  | Data Type  | Constraints                          | Description                      |
|--------------|------------|-------------------------------------|----------------------------------|
| `id`         | INTEGER    | PRIMARY KEY, SERIAL                  | Unique identifier for each employee |
| `firstName`  | VARCHAR(50)| NOT NULL                            | Employee's first name            |
| `lastName`   | VARCHAR(50)| NOT NULL                            | Employee's last name             |
| `department`  | VARCHAR(20)| NOT NULL, CHECK (department IN ('HR', 'Engineering', 'Sales', 'Marketing', 'Finance')) | Employee's department            |
| `position`   | VARCHAR(20)| NOT NULL, CHECK (position IN ('Manager', 'Senior', 'Junior', 'Intern')) | Employee's job title             |
| `phone`      | VARCHAR(15)| NOT NULL                            | Employee's phone number          |
| `email`      | VARCHAR(100)| NOT NULL, UNIQUE                   | Employee's email address         |

### Benefits of the Schema
- **Structured Data Management:** The schema allows for organized storage and retrieval of employee records.
- **Data Integrity:** Constraints ensure that only valid data is entered, preventing inconsistencies.
- **Scalability:** The schema is designed to accommodate a growing number of employee records easily.

## Employee Management API

This is a Spring Boot-based RESTful API designed for managing employee records. It supports CRUD (Create, Read, Update, Delete) operations and uses Spring Data JPA to interact with a relational database (e.g., PostgreSQL).

### Features

- **Create Employee** (`POST /employees`): Allows the creation of a new employee record.
- **Get All Employees** (`GET /employees`): Retrieves a list of all employees.
- **Get Employee by ID** (`GET /employees/{id}`): Retrieves a specific employee's details by ID.
- **Update Employee** (`PUT /employees/{id}`): Updates the details of an existing employee.
- **Delete Employee** (`DELETE /employees/{id}`): Deletes an employee by their ID.

### Technologies Used

- **Spring Boot**: Framework for building the API.
- **Spring Data JPA**: To interact with the database using JPA repositories.
- **PostgreSQL** (or other relational databases): For storing employee records.
- **RESTful API**: Follows REST principles for data access.

- ### Link -
- https://github.com/mbSabari17/employee_management/tree/b87ecf01c6995baddc332d2a990b060ba40f0318/src/main/java/com/example/employee_management

## Questions or Clarifications

If you have any doubts or need clarification regarding the employee details schema or the architecture diagram, please feel free to reach out to me. I'm here to help!

### Contact Details
- **Name:** Sabari Anand
- **Email:** mbsabari17@gmail.com
- **Phone:** +91 978-979-3517

Thank you!

