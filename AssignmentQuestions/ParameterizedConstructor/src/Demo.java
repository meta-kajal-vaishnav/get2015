/**
 * @author Kajal
 *
 */
class User {
	private String name;
	private String email;
	private String companyName;

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", companyName="
				+ companyName + "]";
	}

}

public class Demo {
	public static void main(String args[]) {
		User objUser1 = new User ("Kajal","k@gmail.com");
		objUser1.setCompanyName("Metacube");
		User objUser2 = new User ("Sonal","s@gmail.com");
		
		System.out.println(objUser1);
		System.out.println(objUser2);
	}
}
