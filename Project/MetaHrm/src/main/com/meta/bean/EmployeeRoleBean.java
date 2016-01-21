package main.com.meta.bean;

import org.codehaus.jackson.annotate.JsonIgnore;

import lombok.Data;
import main.com.meta.model.Employee;

@Data
public class EmployeeRoleBean {

	private Integer userRoleId;
	
	@JsonIgnore
	private Employee employee;

	private String role;
}
