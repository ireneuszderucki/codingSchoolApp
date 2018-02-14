package codingSchoolAppP1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class GroupMgmt {
	/**
	 * displays all user groups from database
	 * @param uArray
	 */
	public static void displayAllGroups(Group[] uArray) {
		Group[] allGroups = uArray;
		System.out.println("List of all Groups: \n==============================");
		for (Group group : allGroups) {
			System.out.println(group + "\n");
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
			displayAllGroups(Group.loadAllGroups(conn));
			System.out.println(	"Choose one to proceed:\n" 
					+ "add \t- add a new group\n"
					+ "edit \t- edit an existing group\n"
					+ "delete \t- delete an existing group\n"
					+ "quit \t- quit the program\n"
					+ "Type your choice: ");
			String option = scan.nextLine();
			if (option.equalsIgnoreCase("add")) {
				addGroup(conn, scan);
			}
			else if (option.equalsIgnoreCase("edit")) {
				editGroup(conn, scan);
			}
			else if (option.equalsIgnoreCase("delete")) {
				deleteGroup(conn, scan);
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
	 * scans user input data, creates Group object and saves the object to database
	 * @param conn
	 * @param scan
	 * @throws SQLException
	 */
	
	public static void addGroup(Connection conn, Scanner scan) throws SQLException{
		System.out.println("Type name: ");
		String name = scan.nextLine();
		Group group = new Group(name);
		group.saveGroupToDB(conn);
	}
	
	/**
	 * scans user input data (and validates), creates Group object and saves the edited object to database
	 * @param conn
	 * @param scan
	 * @throws SQLException
	 */
	
	public static void editGroup(Connection conn, Scanner scan) throws SQLException {
		System.out.println("Type name: ");
		String name = scan.nextLine();
		System.out.println("Type ID of the group you want to edit: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int groupId = scan.nextInt();
		Group group = new Group(name);
		group.setId(groupId);
		group.saveGroupToDB(conn);
	}
	
	/**
	 * scans user input (user group id) and deletes the user group from database
	 * @param conn
	 * @param scan
	 * @throws SQLException
	 */
	
	public static void deleteGroup(Connection conn, Scanner scan) throws SQLException {
		System.out.println("Type ID of the user group you want to !DELETE!: ");
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("ID must be an integer! Type again.");
		}
		int groupId = scan.nextInt();
		Group groupToDelete = Group.loadGroupById(conn, groupId);
		groupToDelete.deleteGroup(conn);
	}

}
