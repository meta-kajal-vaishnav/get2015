package main.com.meta.dao;

import java.util.List;

import main.com.meta.model.Employee;

public interface EmployeeDao {
	
	public void addEmployee (Employee employee);
	
	public List<Employee> getAllEmployeesList();
	
	public List<Employee> getAllEmployeesListNew();
	
	public Employee findByUserName(String username);
}
