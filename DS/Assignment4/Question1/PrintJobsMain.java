package Question1;

import java.util.Scanner;

public class PrintJobsMain
{
	public static void main(String[] args) 
	{
		PriorityQueueOfJobs objPriorityQueueOfJobs = null;
		int choice;
		Scanner sc = new Scanner(System.in);
		
		while (true)
		{	
			System.out.println("\n\nMenu : ");
			System.out.println("1). Enter job");
			System.out.println("2). Print jobs");
			System.out.println("3). Exit");
			System.out.println("\nEnter choice");
			choice = sc.nextInt();
			
			switch (choice)
			{
				case 1 : System.out.println("\nEnter number of jobs : ");
						 int numOfJobs = sc.nextInt();
						 objPriorityQueueOfJobs = new PriorityQueueOfJobs (numOfJobs);
						 for ( int index = 0; index < numOfJobs; index++ )
						 {
							 System.out.println("\nEnter job name : ");
							 String jobName = sc.next();
							 System.out.println("\nEnter priority of job : ");
							 int priority = sc.nextInt(); 
							 
							 objPriorityQueueOfJobs.insert(jobName, priority);
						 }
						 break;
						
				case 2 : System.out.println("\nList of print jobs : ");
						 while (objPriorityQueueOfJobs.isEmpty()==false)
							 System.out.println(objPriorityQueueOfJobs.remove());
						 break;
						 
				case 3 : System.exit(0);
				 		  break;
				
				default : System.out.println("Please enter correct choice");
				  		  break;
			}
		}
	}
}
