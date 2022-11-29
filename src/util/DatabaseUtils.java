package util;

import Entity.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *     This class is a helper class for managing database connection
 */
public class DatabaseUtils {

    private static Connection connection;

    public static Connection establishConnection(String url, String username, String password) {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Exception has occurred while establishing database connection: " + e.getMessage());
            connection = null;
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Couldn't close the provided connection");
        }
    }

    public void updatePlayersTable(Player player) {
        //TODO needs database connection
    }
}
