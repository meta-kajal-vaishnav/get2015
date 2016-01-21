/**
 * pojo class for Employee information 
 */
package main.com.meta.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.annotations.Expose;

import lombok.Data;

/**
 * @author Kajal
 *
 */
@Data
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private int employeeId;
	
	@Column(name="emp_name")
	private String employeeName;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@JsonIgnore
	@OneToMany(mappedBy="employee", cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
	private Set<EmployeeRole> userRole;
	
	@JsonIgnore
	@OneToMany(mappedBy="employee", cascade={CascadeType.ALL}, fetch = FetchType.EAGER)//eager else punch in ni
	private Collection<Attendence> attendenceList;
	
	@JsonIgnore
	@ManyToMany(cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name="employee_manager",
        joinColumns={@JoinColumn(name="emp_id")},
        inverseJoinColumns={@JoinColumn(name="manager_id")})
    private Collection<Employee> managers;// = new HashSet<Employee>()
	
	@JsonIgnore
    @ManyToMany(mappedBy="managers", fetch = FetchType.LAZY)
    private Collection<Employee> subordinates;// = new HashSet<Employee>()
	
//	@OneToMany(mappedBy="manager")
//    private Collection<Employee> subordinates;
//	
//	@ManyToOne(cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
//    @JoinColumn(name="manager_id", insertable = false, updatable = false)
//    private Employee manager;
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", username=" + username + ", password="
				+ password + ", enabled=" + enabled + "]";
	}
    
	
}
