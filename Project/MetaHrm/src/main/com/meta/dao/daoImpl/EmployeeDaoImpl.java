/**
 * 
 */
package main.com.meta.dao.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.com.meta.dao.EmployeeDao;
import main.com.meta.model.Attendence;
import main.com.meta.model.Employee;

/**
 * @author Kajal
 *
 */

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee employee) {
		// else org.hibernate.NonUniqueObjectException: a different object 
		// with the same identifier value was already associated with the session
		if(employee.getEmployeeId() != '\0'){
			sessionFactory.getCurrentSession().merge(employee);
		}else{
			sessionFactory.getCurrentSession().saveOrUpdate(employee);
		}
	}

	@Override
	public List<Employee> getAllEmployeesList(){
		List<Employee> empList = sessionFactory.getCurrentSession().createCriteria(Employee.class).list();//ignore admin 
        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        for(Employee employee : empList){
            //Hibernate.initialize(employee.getUserRole());
            //Hibernate.initialize(employee.getAttendenceList());
            Hibernate.initialize(employee.getManagers());
            Hibernate.initialize(employee.getSubordinates());
        }
        return empList;
	}
	
	@Override
	public List<Employee> getAllEmployeesListNew(){
		List<Employee> empList = sessionFactory.getCurrentSession().createCriteria(Employee.class).list();//ignore admin 
        return empList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Employee findByUserName(String username) {
		System.out.println("UserName 11 " +username);
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList = sessionFactory.getCurrentSession().createCriteria(Employee.class)
				.add(Restrictions.eq("username", username)).list();

		if (employeeList.size() > 0) {
			return employeeList.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public Employee findByUserNameNew(String username) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = sessionFactory.getCurrentSession().createCriteria(Employee.class)
				.add(Restrictions.eq("username", username)).list();
		for(Employee employee : employeeList){
			Hibernate.initialize(employee.getAttendenceList());
		}
		if (employeeList.size() > 0) {
			return employeeList.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	public void deleteEmployee(int employeeId){
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Employee.class, employeeId));
	}
	
	@Override
	public List<Employee> getAllSubordinates(Employee employeeModel){
		System.out.println("manager name:" +employeeModel.getEmployeeName());
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Employee.class);
		crit.add(Restrictions.eq("managers", employeeModel));
		return (List<Employee>) crit.list();
	}
}
