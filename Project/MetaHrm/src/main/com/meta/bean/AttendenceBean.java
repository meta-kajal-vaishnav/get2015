package main.com.meta.bean;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.context.annotation.Scope;

import lombok.Data;
import main.com.meta.model.Employee;

@Data
@Scope("session")
public class AttendenceBean {
	
	private int id;
	private Date attendenceDate;
	private String status;
	@JsonIgnore
	private Employee employee;
}
