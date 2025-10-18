import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static String URL = "jdbc:mysql://localhost:3306/stafftracker_db";
    private static String USER = "root";
    private static String PASSWORD = "root123";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            System.err.println("❌ Fail database connection!");
            e.printStackTrace();
        }
        return connection;
    }
}
