import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionOracle {
	public static void main(String[] args) {

		try {

			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "hr";
			String password = "hr";

			Class.forName(driver);
			
			System.out.println("connection to Oracle ..." + "\n");
			Connection connection = DriverManager.getConnection(url, username, password);
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM regions");
			
			System.out.println("-id-region-");
			
			while(resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " ");
				System.out.print(resultSet.getString(2) + " " + "\n");

				System.out.println("--------------------------");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
