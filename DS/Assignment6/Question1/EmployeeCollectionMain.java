package Question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EmployeeCollectionMain 
{
	public static void main(String[] args) 
	{
		Scanner sc = null;
		Employee objEmpoyee = null;
		List<Employee> employeeList = null;
		
		try
		{
			employeeList = new ArrayList<Employee>();
			employeeList.add( new Employee ("Joe", 11, "address1") );
			employeeList.add( new Employee ("Ali", 12, "address2") );
			employeeList.add( new Employee ("Dana", 13, "address3") );
			employeeList.add( new Employee ("Harry", 14, "address4") );
			
			int choice;
			sc = new Scanner(System.in);
			
			while (true)
			{	
				System.out.println("\n\nMenu : ");
				System.out.println("1). Add employee");
				System.out.println("2). Sort employee list in natural order");
				System.out.println("3). Sort employee list according to employee name");
				System.out.println("4). Exit");
				System.out.println("\nEnter choice");
				
				choice = sc.nextInt(); 
				
				switch (choice)
				{
					case 1 : System.out.println("\nEnter employee name : ");
						 String name = sc.next();
						 System.out.println("\nEnter employee id : ");
						 int id = sc.nextInt();
						 System.out.println("\nEnter employee address : ");
						 String address = sc.next();
						 objEmpoyee = new Employee ( name, id, address);
						 boolean flag = false;
						 // if employee id already exists in list, then don't add employee
						 for ( Object employee : employeeList )
						 {
							 if ( employee.equals(objEmpoyee) )
							 {	 
								 flag = true;
								 break;
							 }
						 }
						 if ( flag == false )
							 employeeList.add(objEmpoyee);
						 break;
						
					case 2 : Collections.sort( employeeList );
						 System.out.println("Sort in Natural order");   // according to employee id
						 System.out.println(employeeList);
						 break;
							 
					case 3 : Collections.sort ( employeeList, new EmpNameComparator() );
						 System.out.println ( "Sort using emp name Comparator");
						 System.out.println (employeeList );
						 break;
							 
					case 4 : System.exit(0);
					 	 break;
					
					default : System.out.println("Please enter correct choice");
					  	  break;
				}
			}
		}
		catch (Exception e)
		{
			System.out.println (e);
		}
		finally
		{
			if ( sc != null )
				sc = null;
			
			if ( objEmpoyee != null )
				objEmpoyee = null;
			
			if ( employeeList != null )
				employeeList = null;
		}
		
	}
}
