package Question1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class EmployeeCollectionTest 
{

	@Test
	public void testSortNaturalOrder() // sorts according to employee id
	{
		EmployeeCollectionMain objEmployeeCollectionMain = new EmployeeCollectionMain();
		List<Employee> employeeList  = new ArrayList<Employee>();
		employeeList.add( new Employee ("Joe", 11, "address1") );
		employeeList.add( new Employee ("Ali", 12, "address2") );
		employeeList.add( new Employee ("Dana", 13, "address3") );
		employeeList.add( new Employee ("Harry", 14, "address4") );
		Collections.sort( employeeList );
		
		String strExpected = "[Joe		11	address1, Ali		12	address2, Dana		13	address3, Harry		14	address4]";
		String strOutput = employeeList.toString();
		assertEquals ("Matched", strExpected, strOutput );
	}
	
	
	@Test
	public void testSortAccordingToEmpName() 
	{
		EmployeeCollectionMain objEmployeeCollectionMain = new EmployeeCollectionMain();
		List<Employee> employeeList  = new ArrayList<Employee>();
		employeeList.add( new Employee ("Joe", 11, "address1") );
		employeeList.add( new Employee ("Ali", 12, "address2") );
		employeeList.add( new Employee ("Dana", 13, "address3") );
		employeeList.add( new Employee ("Harry", 14, "address4") );
		Collections.sort( employeeList, new EmpNameComparator() );
		
		String strExpected = "[Ali		12	address2, Dana		13	address3, Harry		14	address4, Joe		11	address1]";
		String strOutput = employeeList.toString();
		assertEquals ("Matched", strExpected, strOutput );
	}

}
