package chainofresponsibility;

/**
 * This is class is responsible for processing the request for leave for 5 day by
 * the HR Manager
 * 
 * @author Kajal
 * 
 */
public class HRManager extends LeaveApprover {

	public void process(Leaves request) {
		if (request.getNoOfDays() > 2 && request.getNoOfDays() <= 5) {
			System.out.println("Leave Sensioned By : HR Manager");
		} else if (successor != null){
			System.out.println("Leave Can Not Be Senssioned");
		}
	}
}
