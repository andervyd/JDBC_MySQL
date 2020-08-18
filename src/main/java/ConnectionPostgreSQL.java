import java.sql.*;

public class ConnectionPostgreSQL {

//	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/db_test";
	private static String username = "postgres";
	private static String password = "postgre";

	public static void main(String[] args) {

		try {

//			Class.forName(driver);

			System.out.println("connection to PostgreSQL ..." + "\n");
			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();
//				statement.executeUpdate("UPDATE public.books SET name = 'Solomon' WHERE id = 1");
			ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " ");
				System.out.print(resultSet.getString(2) + " ");
				System.out.println(resultSet.getDate(3));
				System.out.println("--------------------");
			}

			connection.close();
			System.out.println("\n" + "disconnection on database.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
