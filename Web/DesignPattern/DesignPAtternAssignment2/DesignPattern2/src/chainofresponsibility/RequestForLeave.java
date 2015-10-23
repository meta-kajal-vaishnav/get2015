package chainofresponsibility;

import java.util.Scanner;

/**
 * Main Class that takes the input from the user and handles the request
 * 
 * @author Kajal
 * 
 */
public class RequestForLeave {

	public static void main(String[] args) {
		Scanner sc = null;
		LeaveApprover objLeaveApprover1 = null;
		LeaveApprover objLeaveApprover2 = null;
		LeaveApprover objLeaveApprover3 = null;
		try {
			sc = new Scanner(System.in);
			objLeaveApprover1 = new Mentor();
			objLeaveApprover2 = new SeniorMentor();
			objLeaveApprover3 = new HRManager();
			objLeaveApprover1.setSuccessor(objLeaveApprover2);
			objLeaveApprover2.setSuccessor(objLeaveApprover3);
			System.out.println("Enter the number of days you want leave for : ");
			int days = sc.nextInt();
			Leaves objOfLeaves = new Leaves();
			objOfLeaves.setNoOfDays(days);
			objLeaveApprover1.process(objOfLeaves);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (sc != null)
				sc = null;
			if (objLeaveApprover1 != null)
				objLeaveApprover1 = null;
			if (objLeaveApprover2 != null)
				objLeaveApprover2 = null;
			if (objLeaveApprover3 != null)
				objLeaveApprover3 = null;
		}
	}
}
