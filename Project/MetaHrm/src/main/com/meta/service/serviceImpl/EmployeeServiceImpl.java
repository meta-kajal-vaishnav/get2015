package main.com.meta.service.serviceImpl;

import java.util.List;

import javax.persistence.FetchType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.com.meta.dao.EmployeeDao;
import main.com.meta.model.Employee;
import main.com.meta.service.EmployeeService;

@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Employee> getAllEmployeesList(){
		return employeeDao.getAllEmployeesList();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Employee> getAllEmployeesListNew(){
		return employeeDao.getAllEmployeesList();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Employee findByUserName(String userName) {
		return employeeDao.findByUserName(userName);
	}

}
