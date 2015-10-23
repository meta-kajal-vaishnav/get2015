package chainofresponsibility;

/**
 * This is abstract Class responsible for processing the request for leave
 * @author Kajal
 *
 */
abstract class LeaveApprover {

	protected LeaveApprover successor;

	public void setSuccessor(LeaveApprover successor) {
		this.successor = successor;
	}

	public abstract void process(Leaves request);

}
