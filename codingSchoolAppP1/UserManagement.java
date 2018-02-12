package codingSchoolAppP1;

import java.util.Scanner;

public class UserManagement {
	public static void displayAllUsers(User[] uArray) {
		User[] allUsers = uArray;
		System.out.println("List of all Users: \n==============================");
		for (User user : allUsers) {
			System.out.println(user + "\n");
		}
		System.out.println("==============================");
	}
	public static void optionChoice() {
		Scanner scan = new Scanner(System.in);
		boolean quit = false;
		System.out.println(	"Choose one to proceed:\n" 
				+ "add \t- add a new user\n"
				+ "edit \t- edit an existing user\n"
				+ "delete \t- delete an existing user\n"
				+ "quit \t- quit the program\n"
				+ "Type your choice: ");
		while (!quit) {
			String option = scan.nextLine();
			if (option.equalsIgnoreCase("add")) {
				
			}
			else if (option.equalsIgnoreCase("edit")) {
				
			}
			else if (option.equalsIgnoreCase("delete")) {
				
			}
			else if (option.equalsIgnoreCase("quit")) {
				quit = true;
			}
			else {
				System.out.println("Wrong command! Try again.");
			}
		}
		
	}
	public static void

}
