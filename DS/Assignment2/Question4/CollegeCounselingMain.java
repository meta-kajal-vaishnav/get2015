package Question4;

import java.util.Scanner;

public class CollegeCounselingMain 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		QueueUsingArray objQueueUsingArray = new QueueUsingArray ();
		
		CollegeCounseling objCollegeCounseling = new CollegeCounseling();
		
		objCollegeCounseling.loadStudentData();
		
		objCollegeCounseling.loadCollegeData();
		
		objCollegeCounseling.selectCollege();
	}
}
