package Question1;

public class Jobs 
{
	String jobName;
	int priority;
	
	public Jobs ( String jobName, int priority )
	{
		this.jobName = jobName;
		this.priority = priority;
	}
	
	public String getJobName() {
		return jobName;
	}
	
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
    // toString()
    public String toString() 
    {
        return "Job Name : "+ jobName +"\tPriority : "+ priority;
    }
	
}
