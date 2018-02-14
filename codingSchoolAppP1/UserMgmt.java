package codingSchoolAppP1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UserMgmt {
	
	/**
	 * displays User[] array
	 * @param uArray
	 */
	public static void displayAllUsers(User[] uArray) {
		User[] allUsers = uArray;
		System.out.println("List of all Users: \n==============================");
		for (User user : allUsers) {
			System.out.println(user + "\n");
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
			displayAllUsers(User.loadAllUsers(conn));
			System.out.println(	"Choose one to proceed:\n" 
					+ "add \t- add a new user\n"
					+ "edit \t- edit an existing user\n"
					+ "delete \t- delete an existing user\n"
					+ "quit \t- quit the program\n"
					+ "Type your choice: ");
			String option = scan.nextLine();
			if (option.equalsIgnoreCase("add")) {
				addUser(conn, scan);
			}
			else if (option.equalsIgnoreCase("edit")) {
				editUser(conn, scan);
			}
			else if (option.equalsIgnoreCase("delete")) {
				deleteUser(conn, scan);
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
	 * scans user input data (and validates), creates User object and saves the object to database
	 * @param conn
	 * @param scan
	 * @throws SQLException
	 */
	
	public static void addUser(Connection conn, Scanner scan) throws SQLException{
		System.out.println("Type ID of the user group: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int userGroupId = scan.nextInt();
		System.out.println("Type username: ");
		String username = scan.next();
		System.out.println("Type password: ");
		String password = scan.next();
		System.out.println("Type email: ");
		String email = scan.next();
		User user = new User(userGroupId, username, password, email);
		user.saveUserToDB(conn);
	}
	
	/**
	 * scans user input data (and validates), creates User object and saves the edited object to database
	 * @param conn
	 * @param scan
	 * @throws SQLException
	 */
	
	public static void editUser(Connection conn, Scanner scan) throws SQLException {
		System.out.println("Type ID of the user you want to edit: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int userId = scan.nextInt();
		System.out.println("Type ID of the user group: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int userGroupId = scan.nextInt();
		System.out.println("Type username: ");
		String username = scan.next();
		System.out.println("Type password: ");
		String password = scan.next();
		System.out.println("Type email: ");
		String email = scan.next();
		User user = new User(userGroupId, username, password, email);
		user.setId(userId);
		user.saveUserToDB(conn);
	}
	
	/**
	 * scans user input (user id) and deletes the user from database
	 * @param conn
	 * @param scan
	 * @throws SQLException
	 */
	
	public static void deleteUser(Connection conn, Scanner scan) throws SQLException {
		System.out.println("Type ID of the user you want to !DELETE!: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int userId = scan.nextInt();
		User userToDelete = User.loadUserById(conn, userId);
		userToDelete.deleteUser(conn);
	}

}
