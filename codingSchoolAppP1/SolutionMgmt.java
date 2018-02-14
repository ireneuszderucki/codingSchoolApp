package codingSchoolAppP1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SolutionMgmt {
	/**
	 * displays Solution[] array
	 * @param uArray
	 */
	public static void displayAllSolutions(Solution[] uArray) {
		Solution[] solutions = uArray;
		System.out.println("List of all solutions: \n==============================");
		for (Solution solution : solutions) {
			System.out.println(solution + "\n");
		}
		System.out.println("==============================");
	}
	
//	public static void optionChoice(Connection conn) throws SQLException{
//		Scanner scan = new Scanner(System.in);
//		boolean quit = false;
//		while (!quit) {
//			System.out.println(	"Choose one to proceed:\n" 
//					+ "add \t- add a new solution to an exercise\n"
//					+ "view \t- review your solutions\n"
//					+ "quit \t- quit the program\n"
//					+ "Type your choice: ");
//			String option = scan.nextLine();
//			if (option.equalsIgnoreCase("add")) {
//				addAssign(conn, scan);
//				scan.nextLine(); // I got u
//			}
//			else if (option.equalsIgnoreCase("view")) {
//				viewUserSolutions(conn, scan);
//				scan.nextLine();
//			}
//			else if (option.equalsIgnoreCase("quit")) {
//				quit = true;
//			}
//			else {
//				System.out.println("Wrong command! Try again.");
//			}
//		}
//		
//	}

}
