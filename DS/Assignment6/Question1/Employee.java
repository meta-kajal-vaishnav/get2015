package Question1;

public class Employee implements Comparable<Object>
{
	Integer empId;
	String empName;
	String empAddress;
	
	public Employee ( String empName, Integer empId, String  empAddress )
	{
		this.empName = empName;
		this.empId = empId;
		this.empAddress = empAddress;
	}
	
	public Integer getEmployeeId () {
		return empId;
	}
	
	public void setEmployeeId ( Integer empId ) {
		this.empId = empId;
	}
	
	public String getEmployeeName () {
		return empName;
	}
	
	public void setEmployeeName ( String empName ) {
		this.empName = empName;
	}
	
	public String getEmployeeAddress () {
		return empAddress;
	}
	
	public void setEmployeeAddress ( String empAddress ) {
		this.empAddress = empAddress;
	}
	
	// Override toString()
	public String toString()
	{
		 return getEmployeeName() + "\t\t" + getEmployeeId() + "\t" + getEmployeeAddress() ;
	}
	
	// Implement the natural order for this class i.e. sorts according to employee id
	public int compareTo ( Object o )
	{
		return getEmployeeId().compareTo(((Employee)o).getEmployeeId());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}
	
}
