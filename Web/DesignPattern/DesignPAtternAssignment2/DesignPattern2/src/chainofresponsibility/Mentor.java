package chainofresponsibility;

/**
 * This is class is responsible for processing the request for leave for 1 day by
 * the mentor
 * 
 * @author Kajal
 * 
 */
public class Mentor extends LeaveApprover {

	public void process(Leaves request) {
		if (request.getNoOfDays() == 1) {
			System.out.println("Leave Sensioned By : Mentor");
		} else if (successor != null){
			successor.process(request);
		}
	}
}
