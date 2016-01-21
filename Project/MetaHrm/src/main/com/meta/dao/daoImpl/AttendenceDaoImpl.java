/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.com.meta.dao.daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.com.meta.dao.AttendenceDao;
import main.com.meta.model.Attendence;
import main.com.meta.model.Employee;
/**
 *
 * @author Kajal
 */
@Repository("attendenceDao")
public class AttendenceDaoImpl implements AttendenceDao {
    
    @Autowired
    SessionFactory sessionFactory;
	
    @Override
    public void addAttendence (Attendence attendence) {
        sessionFactory.getCurrentSession().saveOrUpdate(attendence);
    }
    
    @Override
    public Date getLatestAttendence(Employee employee) {
    	System.out.println("emp id : "+employee.getEmployeeId()+"name : "+employee.getEmployeeName());
    	Attendence attendence = null;
    	DetachedCriteria latestAttendence = DetachedCriteria.forClass(
				Attendence.class).setProjection(
				Projections.max("attendenceDate"));
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(
				Attendence.class);
		crit.add(Restrictions.eq("employee", employee));
		crit.add(Property.forName("attendenceDate").eq(latestAttendence));
		attendence =  (Attendence) crit.uniqueResult();
		return attendence.getAttendenceDate();
    }
    
    @Override
    public List<Attendence> getAttendenceList(int employeeId) {
    	return null;
    }
    
}
