/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.com.meta.service.serviceImpl;

import java.util.Date;
import java.util.List;

import main.com.meta.model.Attendence;
import main.com.meta.model.Employee;
import main.com.meta.service.AttendenceService;
import main.com.meta.dao.AttendenceDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Kajal
 */
@Service("attendenceService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AttendenceServiceImpl implements AttendenceService {
    
    @Autowired
    private AttendenceDao attendenceDao;
	
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addAttendence (Attendence attendence) {
        attendenceDao.addAttendence(attendence);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Date getLatestAttendence(Employee employee) {
    	return attendenceDao.getLatestAttendence(employee);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Attendence> getAttendenceList(Employee employeeModel, int pageNumber) {
    	return attendenceDao.getAttendenceList(employeeModel, pageNumber);
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<Attendence> getAllAttendence(Employee employeeModel) {
    	return attendenceDao.getAllAttendence(employeeModel);
    }
}
