package Question1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PrintJobsTest 
{

	@Test
	public void testJobPrinted() 
	{
		int capacityOfPrinter = 2;
		PriorityQueueOfJobs objPriorityQueueOfJobs = new PriorityQueueOfJobs (capacityOfPrinter);
		objPriorityQueueOfJobs.insert("Job1", 2);   // job name, priority are passed as parameters
		objPriorityQueueOfJobs.insert("Job2", 3);
		String jobRemoved = objPriorityQueueOfJobs.remove().getJobName();
		String expectedJobToBeRemoved = "Job2";
		assertEquals ( "Matched", expectedJobToBeRemoved, jobRemoved );
	}

}
