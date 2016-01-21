/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.com.meta.service;

import java.util.Date;
import java.util.List;

import main.com.meta.model.Attendence;
import main.com.meta.model.Employee;

/**
 *
 * @author Kajal
 */
public interface AttendenceService {
	
    public void addAttendence (Attendence attendence);
    
    public Date getLatestAttendence(Employee employee);
    
    public List<Attendence> getAttendenceList(int employeeId);
}
