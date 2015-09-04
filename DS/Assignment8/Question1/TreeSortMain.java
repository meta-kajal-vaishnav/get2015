package Question1;

import java.util.Scanner;

public class TreeSortMain {

	public static void main(String[] args) {
		Scanner sc = null;
		TreeSort objTreeSort = null;

		try {
			objTreeSort = new TreeSort();
			sc = new Scanner(System.in);
			int arrRollNum[] = null;
			while (true) {
				System.out.println("\nMenu : ");
				System.out.println("1). Enter roll number");
				System.out
						.println("2). Display roll numbers in ascending order");
				System.out.println("3). Exit");
				System.out.println("\nEnter your choice : ");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("\nEnter number of students ");
					int numOfStudents = sc.nextInt();
					arrRollNum = new int[numOfStudents];
					System.out.println("\nEnter roll numbers : ");
					for (int index = 0; index < arrRollNum.length; index++)
						arrRollNum[index] = sc.nextInt();
					objTreeSort.insertInTree(arrRollNum);
					break;

				case 2:
					System.out.println("Roll numbers in ascending order : ");
					System.out.println(objTreeSort.printInAscending());
					break;

				case 3:
					System.exit(0);
					break;

				default:
					System.out.println("Please enter correct choice");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (sc != null)
				sc = null;
			if (objTreeSort != null)
				objTreeSort = null;
		}
	}

}
