package codingSchoolAppP1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseMgmt {
	
	/**
	 * displays Exercise[] array
	 * @param uArray
	 */
	public static void displayAllExercises(Exercise[] uArray) {
		Exercise[] allExercises = uArray;
		System.out.println("List of all Exercises: \n==============================");
		for (Exercise exercise : allExercises) {
			System.out.println(exercise + "\n");
		}
		System.out.println("==============================");
	}
	
	public static void displayAllExercisesAsList(ArrayList<Exercise> exercises) {
		ArrayList<Exercise> exercisesList = exercises;
		System.out.println("List of all Exercises: \n==============================");
		for (Exercise exercise : exercisesList) {
			System.out.println(exercise + "\n");
		}
		System.out.println("==============================");
	}
	
	/**
	 * allows the user to choose the operation on the database
	 * @param conn
	 * @throws SQLException
	 */
	public static void optionChoice(Connection conn) throws SQLException{
		Scanner scan = new Scanner(System.in);
		boolean quit = false;
		while (!quit) {
			displayAllExercises(Exercise.loadAllExercises(conn));
			System.out.println(	"Choose one to proceed:\n" 
					+ "add \t- add a new exercise\n"
					+ "edit \t- edit an existing exercise\n"
					+ "delete \t- delete an existing exercise\n"
					+ "quit \t- quit the program\n"
					+ "Type your choice: ");
			String option = scan.nextLine();
			if (option.equalsIgnoreCase("add")) {
				addExercise(conn, scan);
			}
			else if (option.equalsIgnoreCase("edit")) {
				editExercise(conn, scan);
			}
			else if (option.equalsIgnoreCase("delete")) {
				deleteExercise(conn, scan);
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
	 * scans user input data, creates Exercise object and saves the object to database
	 * @param conn
	 * @param scan
	 * @throws SQLException
	 */
	
	public static void addExercise(Connection conn, Scanner scan) throws SQLException{
		System.out.println("Type title: ");
		String title = scan.nextLine();
		System.out.println("Type description: ");
		String description = scan.nextLine();
		Exercise exercise = new Exercise(title, description);
		exercise.saveExerciseToDB(conn);
	}
	
	/**
	 * scans user input data (and validates), creates Exercise object and saves the edited object to database
	 * @param conn
	 * @param scan
	 * @throws SQLException
	 */
	
	public static void editExercise(Connection conn, Scanner scan) throws SQLException {
		System.out.println("Type title: ");
		String title = scan.nextLine();
		System.out.println("Type description: ");
		String description = scan.nextLine();
		System.out.println("Type ID of the exercise you want to edit: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int exerciseId = scan.nextInt();
		Exercise exercise = new Exercise(title, description);
		exercise.setId(exerciseId);
		exercise.saveExerciseToDB(conn);
		
		
	}
	
	/**
	 * scans user input (exercise id) and deletes the exercise from database
	 * @param conn
	 * @param scan
	 * @throws SQLException
	 */
	
	public static void deleteExercise(Connection conn, Scanner scan) throws SQLException {
		System.out.println("Type ID of the exercise you want to !DELETE!: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int exerciseId = scan.nextInt();
		Exercise exerciseToDelete = Exercise.loadExerciseById(conn, exerciseId);
		exerciseToDelete.deleteExercise(conn);
	}

}
