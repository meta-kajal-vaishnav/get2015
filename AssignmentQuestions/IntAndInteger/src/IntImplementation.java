import java.util.ArrayList;
import java.util.List;

public class IntImplementation {

	public static void main(String args[]){
		int number1 = 10;
		int number2 = '\0';
		//		int number3 = null;  // gives error
		String s = "5";

		Integer objInteger1 = new Integer(number1);// wrapper for primitive type int
		Integer objInteger2 = new Integer(number2);
		Integer objInteger3 = null;
		Integer objInteger4 = Integer.parseInt(s);

		List<Integer> listOfNumbers = new ArrayList<Integer>();
		listOfNumbers.add(objInteger1);
		listOfNumbers.add(objInteger2);
		listOfNumbers.add(objInteger4);

		/* Adding this gives null pointer exception*/
		//listOfNumbers.add(objInteger3);

		//		listOfNumbers.add(objInteger3);   gives null pointer exception

		System.out.println("null object : "+objInteger3);

		System.out.println("number2 : "+ number2);

		System.out.println("list :");
		for(int num : listOfNumbers)
			System.out.println(num);

		int n = objInteger4.intValue();
		System.out.println("Number : "+n);

	}
}
