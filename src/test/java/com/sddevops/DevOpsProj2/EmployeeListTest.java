/**
 * 
 */
package com.sddevops.DevOpsProj2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author 65929
 *
 */
class EmployeeListTest {

	private EmployeeList sc;
	private Employee s1;
	private Employee s2;
	private Employee s3;
	private Employee s4;
	private final int EMPLOYEE_LIST_SIZE = 4;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// arrange
		sc = new EmployeeList();
		s1 = new Employee("0001", "Worker_1", "12/01/1993", "Male", "93456543", "Accountant", "Full-Time",
				"Worker_1@email.com");
		s2 = new Employee("0002", "Worker_2", "2/07/1991", "Female", "82567252", "Programmer", "Part-Time",
				"Worker_2@email.com");
		s3 = new Employee("0003", "Worker_3", "15/01/1988", "Male", "90624534", "HR", "Full-Time",
				"Worker_3@email.com");
		s4 = new Employee("0004", "Worker_4", "18/09/1996", "Male", "90624534", "Designer", "Intern",
				"Worker_4@email.com");
		sc.addEmployee(s1);
		sc.addEmployee(s2);
		sc.addEmployee(s3);
		sc.addEmployee(s4);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.sddevops.DevOpsProj2.EmployeeList#getEmployees()}.
	 */
	@Test
	void testGetEmployees() {
		// fail("Not yet implemented");

		// Act
		List<Employee> testSc = sc.getEmployees();

		// Assert
		// Assert that Employee List is not empty after invoking getEmployee function
		// assertTrue(!testSc.isEmpty());
		assertFalse(testSc.isEmpty());

		// Assert that Employee list size contains the correct amount of employees
		// inside
		assertEquals(testSc.size(), EMPLOYEE_LIST_SIZE);
	}

	/**
	 * Test method for
	 * {@link com.sddevops.DevOpsProj2.EmployeeList#addEmployee(com.sddevops.DevOpsProj2.Employee)}.
	 */
	@Test
	void testAddEmployee() {
		// fail("Not yet implemented");

		List<Employee> testSc = sc.getEmployees();

		// Assert that Employee List is equals to employee list size 4
		assertEquals(testSc.size(), EMPLOYEE_LIST_SIZE);

		// Act
		sc.addEmployee(s1);

		// Assert that Employee List is equals to employee list size 4 + 1
		assertEquals(sc.getEmployees().size(), EMPLOYEE_LIST_SIZE + 1);
	}

	/**
	 * Test method for
	 * {@link com.sddevops.DevOpsProj2.EmployeeList#sortEmployeesByRole()}.
	 */
	@Test
	void testSortEmployeesByRole() {
		// fail("Not yet implemented");

		// Act
		List<Employee> testSc = sc.sortEmployeesByRole();

		// Arrange
		String newEmployeeRole1 = testSc.get(0).getRole();
		String newEmployeeRole2 = testSc.get(1).getRole();
		String newEmployeeRole3 = testSc.get(2).getRole();
		String newEmployeeRole4 = testSc.get(3).getRole();

		// Assert that the employee's role list had now been sorted from [A-Z][a-z]
		assertEquals(newEmployeeRole1, "Accountant");
		assertEquals(newEmployeeRole2, "Designer");
		assertEquals(newEmployeeRole3, "HR");
		assertEquals(newEmployeeRole4, "Programmer");
	}

	/**
	 * Test method for
	 * {@link com.sddevops.DevOpsProj2.EmployeeList#sortEmployeesByType()}.
	 */
	@Test
	void testSortEmployeesByType() {
		// fail("Not yet implemented");

		// Act
		List<Employee> testSc = sc.sortEmployeesByType();

		// Arrange
		String newEmployeeType1 = testSc.get(0).getType();
		String newEmployeeType2 = testSc.get(1).getType();
		String newEmployeeType3 = testSc.get(2).getType();
		String newEmployeeType4 = testSc.get(3).getType();

		// Assert that the employee's type list had now been sorted from [A-Z][a-z]
		assertEquals(newEmployeeType1, "Full-Time");
		assertEquals(newEmployeeType2, "Full-Time");
		assertEquals(newEmployeeType3, "Intern");
		assertEquals(newEmployeeType4, "Part-Time");
	}

	/**
	 * Test method for
	 * {@link com.sddevops.DevOpsProj2.EmployeeList#findEmployeesById(java.lang.String)}.
	 */
	@Test
	void testFindEmployeesById() {
		// fail("Not yet implemented");
		// Act
		Employee validEmployee = sc.findEmployeesById("0003");
		Employee invalidEmployee = sc.findEmployeesById("Invalid Id");

		// Assert we retrieve a valid Song
		assertNotNull(validEmployee);
		// Assert we retrieve the accurate Song base on Id
		assertEquals(validEmployee.getName(), "Worker_3");
		// Assert we get a null when we input a invalid Id
		assertNull(invalidEmployee);
	}

	/**
	 * Test method for
	 * {@link com.sddevops.DevOpsProj2.EmployeeList#findEmployeesByName(java.lang.String)}.
	 */
	@Test
	void testFindEmployeesByName() {
		// fail("Not yet implemented");

		// Act
		Employee validEmployee = sc.findEmployeesByName("Worker_3");
		Employee invalidEmployee = sc.findEmployeesByName("Worker doesn't exists");

		// Assert we retrieve a valid Song
		assertNotNull(validEmployee);
		// Assert we retrieve the accurate Song base on Id
		assertEquals(validEmployee.getId(), "0003");
		// Assert we get a null when we input a invalid Title
		assertNull(invalidEmployee);
	}

	/**
	 * Test method for
	 * {@link com.sddevops.DevOpsProj2.EmployeeList#findEmployeeByRole(java.lang.String)}.
	 */
	@Test
	void testFindEmployeeByRole() {
		// fail("Not yet implemented");
		// Act
		Employee validEmployee = sc.findEmployeeByRole("Designer");
		Employee invalidEmployee = sc.findEmployeeByRole("Role doesn't exists");

		// Assert we retrieve a valid Song
		assertNotNull(validEmployee);
		// Assert we retrieve the accurate Song base on Id
		assertEquals(validEmployee.getName(), "Worker_4");
		// Assert we get a null when we input a invalid Title
		assertNull(invalidEmployee);
	}

}
