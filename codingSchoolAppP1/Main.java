package codingSchoolAppP1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;

//Program 1 - zarządzanie użytkownikami
//Program po uruchomieniu wyświetli na konsoli listę wszystkich użytkowników.
//
//Następnie wyświetli
//
//"Wybierz jedną z opcji:"
//
//add - dodanie użytkownika
//edit - edycja użytkownika
//delete - edycja użytkownika
//quit - zakończenie programu
//W przypadku quit - program zakończy działanie.

public class Main {

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coding_school?useSSL=false", 
				"root", 
				"coderslab")) 
		{
//			UserMgmt.optionChoice(conn);
//			ExerciseMgmt.optionChoice(conn);
//			GroupMgmt.optionChoice(conn);
//			ExerciseAssign.optionChoice(conn);
			int userId = Integer.parseInt(args[0]);
			System.out.println(userId);
			
			
		
		
			
			
			
			

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
