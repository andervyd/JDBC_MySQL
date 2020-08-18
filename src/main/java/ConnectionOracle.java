import java.sql.*;

public class ConnectionOracle {

//	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "hr";
	private static String password = "hr";

	public static void main(String[] args) {

		try {

//			Class.forName(driver);

			System.out.println("connection to Oracle ..." + "\n");
			Connection connection = DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM regions");

			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " ");
				System.out.println(resultSet.getString(2));
				System.out.println("------------------------");
			}

			connection.close();
			System.out.println("\n" + "disconnection on database.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
