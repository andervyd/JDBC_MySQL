import java.sql.*;

public class ConnectionMySQL {

//	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/sakila";
	private static String username = "root";
	private static String password = "mysql";

	public static void main(String[] args) {

		try {

//			Class.forName(driver);

			System.out.println("Connection to MySQL ..." + "\n");
			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM actor");

			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " ");
				System.out.print(resultSet.getString(2) + " ");
				System.out.print(resultSet.getString(3) + " ");
				System.out.println(resultSet.getDate(4));
				System.out.println("----------------------------");
			}

			connection.close();
			System.out.println("\n" + "disconnection on database.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}