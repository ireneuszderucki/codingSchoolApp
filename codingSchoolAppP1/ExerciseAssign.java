package codingSchoolAppP1;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ExerciseAssign {

	/**
	 * allows the user to choose the operation on the database
	 * @param conn
	 * @throws SQLException
	 */
	public static void optionChoice(Connection conn) throws SQLException{
		Scanner scan = new Scanner(System.in);
		boolean quit = false;
		while (!quit) {
			System.out.println(	"Choose one to proceed:\n" 
					+ "add \t- assign user to an exercise\n"
					+ "view \t- review solutions of a given user\n"
					+ "quit \t- quit the program\n"
					+ "Type your choice: ");
			String option = scan.nextLine();
			if (option.equalsIgnoreCase("add")) {
				addAssign(conn, scan);
				scan.nextLine(); // I got u
			}
			else if (option.equalsIgnoreCase("view")) {
				viewUserSolutions(conn, scan);
				scan.nextLine();
			}
			else if (option.equalsIgnoreCase("quit")) {
				quit = true;
			}
			else {
				System.out.println("Wrong command! Try again.");
			}
		}
		
	}
	/**
	 * assigns users to exercises, creates Solution object
	 * @param conn
	 * @param scan
	 * @throws SQLException
	 */
	
	public static void addAssign(Connection conn, Scanner scan) throws SQLException{
		UserMgmt.displayAllUsers(User.loadAllUsers(conn));
		System.out.println("Type ID of the user: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int userId = scan.nextInt();
		ExerciseMgmt.displayAllExercises(Exercise.loadAllExercises(conn));
		System.out.println("Type ID of the exercise: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int exerciseId = scan.nextInt();
		String created = LocalDateTime.now().toString();
		Solution solution = new Solution(exerciseId, userId, created, null, null);
		solution.saveSolutionToDB(conn);
	}
	
	static public void viewUserSolutions(Connection conn, Scanner scan) throws SQLException {
		System.out.println("Type ID of the user to see assigned solutions: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int userId = scan.nextInt();
		SolutionMgmt.displayAllSolutions(Solution.loadAllSolutionsByUserId(conn, userId));
	}

}
