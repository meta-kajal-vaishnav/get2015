package Question1;

import java.util.Comparator;

public class EmpNameComparator implements Comparator<Object>
{
	// sorts according to employee name
	public int compare ( Object obj1, Object obj2 )
	{
		Employee emp1 = (Employee)obj1;
		Employee emp2 = (Employee)obj2;
		if ( ( emp1.getEmployeeName() == null ) && ( emp2.getEmployeeName() == null ) )
			return 0;
		else 
			return emp1.getEmployeeName().compareTo( emp2.getEmployeeName() ) ;
	}
}
