package codingSchoolAppP1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/coding_school?useSSL=false", 
				"root", 
				"coderslab")) {
			
			

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
