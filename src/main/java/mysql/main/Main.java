package mysql.main;

import mysql.connection.ConnectionToBaseMySQL;

public class Main {
    public static void main(String[] args) {

        ConnectionToBaseMySQL connection = new ConnectionToBaseMySQL();
        connection.connectionToDatabase("mydb");

    }
}
