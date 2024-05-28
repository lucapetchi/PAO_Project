package Bank.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseConfig {

    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/bank";

    //jdbc:mysql://localhost:3307/bank
    private static final String USER = "User";

    private static final String PASSWORD = "MyRandomPassword";

    private static Connection connection;

    private DatabaseConfig() {
    }

    public static Connection getDatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void closeDatabaseConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}