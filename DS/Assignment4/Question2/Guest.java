package Question2;

public class Guest
{
	String guestName;
	int age;
	
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Guest ()
	{}
	
	public Guest ( String guestName, int age )
	{
		this.guestName = guestName;
		this.age = age;
	}
}
