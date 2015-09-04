package Question2;

import java.util.Scanner;

public class SortingSystemMain {
	static int arrNumbers[];

	public static void main(String[] args) {
		int sortType = 0;
		Scanner sc = null;
		SortingSystem objSortingSystem = null;
		SortingSystemMain objSortingSystemMain = null;

		try {
			objSortingSystem = new SortingSystem();
			objSortingSystemMain = new SortingSystemMain();
			sc = new Scanner(System.in);
			int typeOfSorting = 0;

			while (true) {
				System.out.println("\n\nMenu : ");
				System.out.println("1). Enter numbers to be sorted");
				System.out.println("2). Choose type of sorting");
				System.out.println("3). Display sorted numbers");
				System.out.println("4). Exit");
				System.out.println("\nEnter your choice : ");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("\nEnter number of items ");
					int numOfItems = sc.nextInt();
					arrNumbers = new int[numOfItems];
					System.out.println("\nEnter numbers : ");
					for (int index = 0; index < arrNumbers.length; index++)
						arrNumbers[index] = sc.nextInt();
					break;

				case 2:
					do {
						System.out.println("\nChoose type of Sorting : ");
						System.out.println("1). Comparison Sorting");
						System.out.println("2). Linear Sorting");
						System.out.println("\nEnter your choice : ");
						typeOfSorting = sc.nextInt();
					} while ((typeOfSorting != 1) && (typeOfSorting != 2));

					sortType = objSortingSystem.selectSortType(arrNumbers,
							typeOfSorting, objSortingSystem, sortType);
					break;

				case 3:
					System.out
							.println(objSortingSystem.printSortType(sortType));
					objSortingSystem.printArray(arrNumbers);
					break;

				case 4:
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
			if (objSortingSystem != null)
				objSortingSystem = null;
			if (objSortingSystemMain != null)
				objSortingSystemMain = null;
		}
	}
}
