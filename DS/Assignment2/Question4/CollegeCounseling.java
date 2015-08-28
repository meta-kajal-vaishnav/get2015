// college counseling system
package Question4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollegeCounseling
{
	static String fileName = "C://Users/Kajal/workspace/Assignment12/src/Question4/";
	int totalSeats = 0, totalStudents = 0;
	
	QueueUsingArray objCollegeQueueUsingArray = new QueueUsingArray ();
	QueueUsingArray objStudentQueueUsingArray = new QueueUsingArray ();
	
	Scanner sc = new Scanner(System.in);
	
	List<Student> studentList = new ArrayList<Student>();
	List<College> collegeList = new ArrayList<College>();
	
	// loads student data from file into list . then sorts it according to student's rank and inserts it in student queue 
	public void loadStudentData()
	{
		Student objStudent ;
		
		try
		{	
			File file = new File(fileName+"StudentsData.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null)
			{
				totalStudents = totalStudents + 1;
		   		String arr[] = line.split(",");
		    		objStudent = new Student ();
		    		objStudent.setStudentName(arr[0]);
		    		objStudent.setStudentRank(Integer.parseInt(arr[1]));
		    		studentList.add(objStudent);
			}
		    	br.close();
			fr.close();
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}	
		
		// bubble sorting on student data list according to his rank 
		for ( int index = 0; index<studentList.size() ; index++)
		{
			for ( int index1 = 0; index1<studentList.size()-1 ; index1++)
			{
				if ( studentList.get(index1).studentRank > studentList.get(index1+1).studentRank )
				{
					Student tempObj = studentList.get(index1);
					studentList.set(index1,studentList.get(index1+1)) ;
					studentList.set(index1+1,tempObj);
				}
			}
		}

		// insert sorted data in student queue
		for ( Student studentInfo : studentList )
			objStudentQueueUsingArray.enqueue(studentInfo);
	}
	
	
	// loads college data from file into college list
	public void loadCollegeData()
	{
		College objCollege ;
		
		try
		{	
			File file = new File ( fileName+"CollegeData.txt" );
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null)
			{
		    		String arr[] = line.split(",");
		    		objCollege = new College ();
		    		objCollege.setCollegeName(arr[0]);
		    		objCollege.setTotalNumOfSeats(Integer.parseInt(arr[1]));
		    		totalSeats = totalSeats + Integer.parseInt(arr[1]);
		    		collegeList.add(objCollege);
			}
		    	br.close();
			 fr.close();
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}	
	}
	
	// allots college to students
	public void selectCollege()
	{
		for ( int index = 0; index<=totalStudents; index++)
		{
			boolean flagSeatAllocated = false, flagSeatAllocatedClgFound = false;
				
			Student student = (Student)objStudentQueueUsingArray.dequeue();
				
			do
			{
				flagSeatAllocated = false;
				for ( College collegeInfo : collegeList )
				{
					if(collegeInfo.getTotalNumOfSeats() != 0)
						System.out.println ("College Name : "+collegeInfo.collegeName+"\tNum Of Seats : "+collegeInfo.totalNumOfSeats);
				}
					
				System.out.println("\nStudent : "+student.getStudentName()+"\t Rank : "+student.getStudentRank());
					
				System.out.println ("\nEnter college name of your choice : ");
					
				String collegeName = sc.next();
					
				for ( College collegeInfo : collegeList )
				{
					// if college name is matches and its seats are not full then allocate it to student
					if ( collegeInfo.collegeName.equalsIgnoreCase(collegeName) && collegeInfo.getTotalNumOfSeats() != 0 )
					{	
						flagSeatAllocatedClgFound = true;
						if ( collegeInfo.totalNumOfSeats != 0 )
						{
							collegeInfo.totalNumOfSeats -= 1;
							student.setCollegeName(collegeName);
							totalSeats -= 1;
							objStudentQueueUsingArray.enqueue (student);
							System.out.println("\nCollege alloted successfully\n");
							flagSeatAllocated = true;
							break;
						}
						else
							System.out.println ("Seats full");
					}
				}
				if ( flagSeatAllocatedClgFound == false )
					System.out.println ("College not found\n");
			}while (totalSeats > 0 && (flagSeatAllocatedClgFound == false || flagSeatAllocated == false) );
				
			if(totalSeats == 0)
				break;	
		}
		System.out.println ("\nCounseling result\n");
		objStudentQueueUsingArray.printQueue();
	}
	
}
