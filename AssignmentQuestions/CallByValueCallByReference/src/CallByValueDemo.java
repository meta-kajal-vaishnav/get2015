
public class CallByValueDemo {
	
	public static void main(String args[]){
		
		int number = 4;
		System.out.println("Value of number before calling function : "+number);
		increaseNumberByOne(number);
		System.out.println("Value of number after calling function : "+number);
	}
	
	public static void increaseNumberByOne(int number){
		number = number+1;
		System.out.println("Value of number after increasing : "+number);
	}

}
