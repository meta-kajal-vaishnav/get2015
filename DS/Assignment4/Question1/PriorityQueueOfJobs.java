package Question1;
 
public class PriorityQueueOfJobs
{
	 Jobs[] heap; 
	 int heapSize, capacity;
	 
	 // Constructor 
	 public PriorityQueueOfJobs ( int capacity )
	 {    
		 this.capacity = capacity + 1;
		 heap = new Jobs[this.capacity];
		 heapSize = 0;
	 }
	 
	 // function to clear
	 public void clear()
	 {
	 	heap = new Jobs[capacity];
	 	heapSize = 0;
	 }
	 
	 // function to check if empty 
	 public boolean isEmpty()
	 {
		 return heapSize == 0;
	 }
	 
	 // function to check if full 
	 public boolean isFull()
	 {
		 return heapSize == capacity - 1;
	 }
	 
	 // function to get Size
	 public int size()
	 {
		 return heapSize;
	 }
	 
	 // function to insert job
	 public void insert(String job, int priority)
	 {
		 Jobs newJob = new Jobs(job, priority);
	 
		 heap[++heapSize] = newJob;
	 	 int position = heapSize;
	         while (position != 1 && newJob.priority > heap[position/2].priority)
	         {
	         	heap[position] = heap[position/2];
	         	position /=2;
	         }
	         heap[position] = newJob;    
	 }
	    
	 // function to remove job
	 public Jobs remove()
	 {
		int parent, child;
	 	Jobs item, temp;
	 	if (isEmpty() )
	 	{
		 	System.out.println("Heap is empty");
	 		return null;
	 	}
	 
	    	item = heap[1];    //  Ist element to remove i.e. root
	    	temp = heap[heapSize--];   // last element
	 
	    	parent = 1;
	    	child = 2;
	    	while (child <= heapSize)
		{
//	    		if ( child < heapSize && heap[child].priority < heap[child + 1].priority )
//	    		child++;
	    		if ( temp.priority >= heap[child].priority )    // if last element has highest priority then break
				break;
	    		heap[parent] = heap[child];     // else if child has > priority then temp then place child in place of removed root node
	    		parent = child;					// child placed in  root becomes new parent
	    		child *= 2;						// finding child of new root
	    	}
	    	heap[parent] = temp;
	    	return item;
	 }
 
}
