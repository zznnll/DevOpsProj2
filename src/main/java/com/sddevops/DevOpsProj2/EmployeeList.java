package com.sddevops.DevOpsProj2;

import java.util.*;

public class EmployeeList {

	private ArrayList<Employee> employees = new ArrayList<>();
    private int capacity;

    public EmployeeList() {
    	/*employees.add(new Employee("Worker_1","12/01/1993","Male","93456543","Accountant","Full-Time","Worker_1@email.com"));
    	employees.add(new Employee("Worker_2","2/07/1991","Female","82567252","Programmer","Part-Time","Worker_2@email.com"));
    	employees.add(new Employee("Worker_3","15/01/1988","Male","90624534","HR","Full-Time","Worker_3@email.com"));
    	employees.add(new Employee("Worker_4","18/09/1996","Male","90624534","Designer","Intern","Worker_4@email.com"));*/

        this.capacity = 20;
    }

    public EmployeeList(int capacity) {
        this.capacity = capacity;
    }


    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployees(Employee employee) {
    	if(employees.size() != capacity) {
    		employees.add(employee);
    	}
    }
    
    public ArrayList<Employee> sortEmployeesByRole() {         
        Collections.sort(employees, Employee.roleComparator);         
        return employees;     
    } 
    
    public ArrayList<Employee> sortEmployeesByEmployeeType() {         
        Collections.sort(employees, Employee.typeComparator);         
        return employees;     
    } 
    
    public Employee findEmployeesByName(String name) {
    	for (Employee s : employees) { 		      
            if(s.getName().equals(name)) return s;
       }
    	return null;
    }

    public Employee findEmployeeByRole(String role) {
    	for (Employee s : employees) { 		      
            if(s.getRole().equals(role)) return s;
       }
    	return null;
    }

}
