package main.com.meta.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="employee_role")
public class EmployeeRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userRoleId")
	private Integer userRoleId;
	
	@JsonIgnore
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="emp_id")
	private Employee employee;
	
	@Column(name="role")
	private String role;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRole other = (EmployeeRole) obj;
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userRoleId == null) ? 0 : userRoleId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "EmployeeRole [userRoleId=" + userRoleId + ", role=" + role
				+ "]";
	}

	

}
