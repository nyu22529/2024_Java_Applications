package gui.builder.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/java_b?serverTimezone=UTC",
					"root",
					"rootroot");
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");
			
			System.out.println("학번" + "\t" + "이름" + "\t" + "학과" + "\t\t" + "학년");
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				int grade = rs.getInt("grade");
				/* String name = rs.getString(2); */
				
				System.out.println(id + "\t" + name + "\t" + dept + "\t" + grade);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
