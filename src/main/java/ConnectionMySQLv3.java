import java.sql.*;

public class ConnectionMySQLv3 {
	public static void main(String[] args) {

		try {

			String driver = "net.sf.log4jdbc.DriverSpy";
			String url = "jdbc:log4jdbc:mysql://localhost:3306/sakila";
			String username = "root";
			String password = "mysql";

			Class.forName(driver);
			
			System.out.println("connection to MySQL ..." + "\n");
			Connection connection = DriverManager.getConnection(url, username, password);
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM actor");
			
			while(resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " ");
				System.out.print(resultSet.getString(2) + " ");
				System.out.print(resultSet.getString(3) + " ");
				System.out.println(resultSet.getDate(4));
				System.out.println("------------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("check connection...");
	}
}