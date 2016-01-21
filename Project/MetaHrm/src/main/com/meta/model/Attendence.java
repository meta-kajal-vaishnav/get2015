package main.com.meta.model;

import java.util.Date;

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

/**
 * @author Kajal
 *
 */
@Data
@Entity
@Table(name="attendence")
public class Attendence {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Date attendenceDate;
	
	@Column(name="status")
	private String status;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;
}
