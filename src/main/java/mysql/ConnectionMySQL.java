package mysql;

import java.sql.*;

public class ConnectionMySQL {

//	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mydb";
	private static String username = "root";
	private static String password = "root";

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(url, username, password)) {

//			Class.forName(driver);

			System.out.println("Connection to MySQL ..." + "\n");

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

			System.out.println("id   name   salary \n------------------");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + "    ");
				System.out.print(resultSet.getString(2) + "   ");
				System.out.print(resultSet.getDouble(3) + " ");
//				System.out.println(resultSet.getDate(4));
				System.out.println();
			}

//			connection.close();
			System.out.println("\n" + "disconnection on database.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}