import java.sql.*;

public class ConnectionPostgreSQL {
	public static void main(String[] args) {
		
		try {

			String driver = "org.postgresql.Driver";
			String url = "jdbc:postgresql://localhost:5432/db_test";
			String username = "postgres";
			String password = "postgre";

			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			Statement statement = connection.createStatement();
//				statement.executeUpdate("UPDATE public.books SET name = 'Solomon' WHERE id = 1");
			ResultSet resultSet = statement.executeQuery("SELECT * FROM public.books");
			
			System.out.println("-id-name-");
			
			while(resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " ");
				System.out.print(resultSet.getString(2) + " " + "\n");

				System.out.println("---------------");
			}
			
			connection.close();
			System.out.println("disconnect...");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
