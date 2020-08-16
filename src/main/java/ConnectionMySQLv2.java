import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectionMySQLv2 {
	public static void main(String[] args) {

		try {

			String nameTable = "actor";
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sakila";
			String username = "root";
			String password = "mysql";

			Class.forName(driver);

			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection to MySQL v2 ..." + "\n");
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM " + nameTable);
			
			System.out.println("Connection to table: " + nameTable + " ..." + "\n");
			
			while(resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " ");
				System.out.print(resultSet.getString(2) + " ");
				System.out.print(resultSet.getString(3) + " ");
				System.out.println(resultSet.getDate(4));
				System.out.println("------------------------------");
			}
				
			System.out.println("\n" + "End connection to table: " + nameTable);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}