
public class CallByReferenceDemo {

public static void main(String args[]){
		Number number = new Number();
		number.a = 3;
		System.out.println("Value of number before calling function : "+number.a);
		increaseNumberByOne(number);
		System.out.println("Value of number after calling function : "+number.a);
	}
	
	public static void increaseNumberByOne(Number number){
		number.a = number.a+1;
		System.out.println("Value of number after increasing : "+number.a);
	}
}

class Number {
	int a;
}
