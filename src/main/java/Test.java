import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionString = "jdbc:mysql://localhost:3306/sakila";
    private final String login = "root";
    private final String password = "mysql";
    public void run() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Can't get class. No driver found");
            e.printStackTrace();
            return;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionString, login, password);
        } catch (SQLException e) {
            System.out.println("Can't get connection. Incorrect URL");
            e.printStackTrace();
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't close connection");
            e.printStackTrace();
            return;
        }
        finally {
        	
        }
        System.out.println("connect...");
    }
    public static void main(String[] args) {
        Test app = new Test();
        app.run();
    }
}

