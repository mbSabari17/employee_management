 Feature: Employee Management API
   Background:
    Given the API is available at "http://localhost:3000/api/v1/MBSABARI17_1/EmployeeManagementV1/1.0.0"
  Scenario: Attempt to Retrieve a list of employees
    When I send a GET request to "/employees"
    Then the response status code should be 200
    And the response body should be an array of employees
  Scenario: Attempt to Retrieve an employee by valid ID
    Given an employee with ID exists
    When I send a GET request to "/employees/ID"
    Then the response status code should be 200
    And the response body should include the employee details
   Scenario: Attempt to retrieve an employee by non-existent ID
    When I send a GET request to "/employees/non-existent"
    Then the response status code should be 404
    And the response body should indicate "Employee not found"
   Scenario: Attempt to retrieve an employee with invalid ID
    When I send a GET request to "/employees/Invalid ID"
    Then the response status code should be 400
    And the response body should indicate "Bad request - invalid input"
   Scenario: Create a new employee successfully
    Given I have a new employee with the following details:
      | firstName | lastName | department  | position | phone        | email             |
    When I send a POST request to "/employees" with the valid employee details
    Then the response status code should be 201
    And the response body should include the employee details
   Scenario: Attempt to create an employee with invalid input
    Given I have an employee with invalid details:
      | firstName | lastName | department | position | phone | email     |
    When I send a POST request to "/employees" with the invalid employee details
    Then the response status code should be 400
    And the response body should indicate "Bad request - invalid input"
   Scenario: Attempt to Update an existing employee successfully
    Given an employee with ID "1" exists
    And I have updated the employee details:
      | firstName | lastName | department | position | phone        | email             |
    When I send a PUT request to "/employees/valid ID" with the updated details
    Then the response status code should be 200
    And the response body should include the updated employee details
   Scenario: Attempt to update an employee with invalid input
    Given an employee with ID  exists
    And I have updated the employee with invalid details:
      | firstName | lastName | department | position | phone | email     |
    When I send a PUT request to "/employees/" with the invalid updated details
    Then the response status code should be 400
    And the response body should indicate "Bad request - invalid input"
   Scenario: Attempt to update a non-existent employee
    Given an employee with non-existent ID
    And I have updated the employee details:
      | firstName | lastName | department | position | phone        | email             |
    When I send a PUT request to "/employees/non-existent" with the updated details
    Then the response status code should be 404
    And the response body should indicate "Employee not found"
   Scenario: Delete an employee successfully
    Given an employee with ID exists
    When I send a DELETE request to "/employees/Valid ID"
    Then the response status code should be 204
    And the employee with ID should no longer exist
  Scenario: Attempt to delete a non-existent employee
    When I send a DELETE request to "/employees/non-existent"
    Then the response status code should be 404
    And the response body should indicate "Employee not found"






