/**
 * 
 */
package main.com.meta.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import main.com.meta.model.Attendence;
import main.com.meta.model.Employee;
import main.com.meta.model.EmployeeRole;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.context.annotation.Scope;

/**
 * @author Kajal
 *
 */
@Data
@Scope("session")
public class EmployeeBean {

	private int employeeId;
	
	private String employeeName;
	
	private String username;
	
	private String password;
	
	private boolean enabled;
	
	@JsonIgnore
	private Set<EmployeeRole> userRole = new HashSet<EmployeeRole>(0);
	
	@JsonIgnore
	private Collection<Attendence> attendenceList = new ArrayList<Attendence>();
	
	@JsonIgnore
    private Collection<Employee> managers = new HashSet<Employee>();
	
	@JsonIgnore
    private Collection<Employee> subordinates = new HashSet<Employee>();
    
}
