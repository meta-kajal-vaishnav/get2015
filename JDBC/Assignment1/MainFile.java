import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MainFile {

	public static void main(String[] args) throws ParseException, IOException {

		int choice = 0;
		LibraryInformationSystemHelper objectOfInformationSystemHelper = null;
		Scanner sc = null;
		BufferedReader br = null;

		try
		{
			objectOfInformationSystemHelper = new LibraryInformationSystemHelper();
			sc = new Scanner(System.in);
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while (true) {
				System.out.println("\n\nMenu : ");
				System.out.println("1). Fetch all the books published by given author");
				System.out.println("2). Find if book has been issued or not by existing member");
				System.out.println("3). Delete & return count of books not issued in last 1 year");
				System.out.println("4). Exit");
				System.out.println("\nEnter choice");
				choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter author name : ");
					String authorName = sc.next();
					List<Title> titleList = objectOfInformationSystemHelper
							.booksPublishedByAuthor(authorName);
					/* if returned list of titles is empty means that author name is invalid i.e. does not exist in database */
					if (titleList.isEmpty())
						System.out.println("Enter a valid author name");
					else {
						/* prints list of titles of books written by given author */
						for (Title s : titleList)
							System.out.println(s.getSubjectId() + "\t"
									+ s.getTitleId() + "\t" 
									+ s.getTitleName()+ "\t" 
									+ s.getPublisherId());
					}
					break;

				case 2:
					System.out.println("Enter name of book to be issued");
					String bookName = br.readLine();
					String memberName = "";
					int accessionNumber = objectOfInformationSystemHelper.bookAvailable(bookName);
					if (accessionNumber == 0)
						System.out.println("Book doesnot exists");
					else {
						System.out.println("Enter member name");
						memberName = sc.next();
						boolean flag = objectOfInformationSystemHelper.bookIssuedOrNot(memberName, accessionNumber);
						if (flag)
							System.out.println("Book issued successfully");
						else
							System.out.println("Please enter a valid member name");
					}
					break;

				case 3:
					System.out.println("Number of deleted books = "+ objectOfInformationSystemHelper.deleteBooksNotIssuedSinceOneYear());
					break;

				case 4:
					System.exit(0);
					break;

				default:
					System.out.println("Please enter correct choice");
					break;
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if( sc != null )
				sc = null;
			if( br != null )
				br = null;
			if( objectOfInformationSystemHelper != null )
				objectOfInformationSystemHelper = null;
		}
	}
}
