/**
 * 
 */
package main.com.meta.service;

import java.util.List;

import main.com.meta.model.Employee;

/**
 * @author Kajal
 *
 */
public interface EmployeeService {
	
	public void addEmployee (Employee employee);
	
	public List<Employee> getAllEmployeesList();
	
	public List<Employee> getAllEmployeesListNew();
	
	public Employee findByUserName(String userName);
	
	public Employee findByUserNameNew(String userName);
	
	public void deleteEmployee(int employeeId);
	
	public List<Employee> getAllSubordinates(Employee employeeModel);
	
}
