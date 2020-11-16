package mysql.connection;


import mysql.employees.Employee;

import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

public class ConnectionToBaseMySQL {

    private static String nameDatabase;
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public void connectionToDatabase(String nameDatabase) {

        try (Connection connection = DriverManager.getConnection(URL + nameDatabase, USERNAME, PASSWORD)) {

            if (!connection.isClosed()) {

                System.out.println("Connection to database: '" + nameDatabase + "'");

                System.out.println("Enter query ...");
                Scanner inputQuery = new Scanner(System.in);

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(new String(inputQuery.nextLine()));

                System.out.println("id   name   salary \n------------------");
                while (resultSet.next()) {

                    Employee employee = new Employee();

                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setSalary(resultSet.getDouble("salary"));

                    System.out.println(employee);

                }
            }

        } catch (SQLSyntaxErrorException e) {
            System.out.println(e.getMessage());
            //            System.out.println("You have an error in your SQL syntax");
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        } finally {

            System.out.println("Connection is close.");

        }


    }

}
