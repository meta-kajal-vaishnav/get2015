package chainofresponsibility;

/**
 * This is class is responsible for processing the request for leave for 2 day by
 * the senior mentor
 * 
 * @author Kajal
 * 
 */
public class SeniorMentor extends LeaveApprover {

	public void process(Leaves request) {
		if (request.getNoOfDays() == 2) {
			System.out.println("Leave Sensioned By :  Senior Mentor");
		} else if (successor != null){
			successor.process(request);
		}
	}
}
