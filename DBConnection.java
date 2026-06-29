import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class DBConnection {
    private static final Map<String, String> env = EnvLoader.loadEnv(".env");

    private static final String URL = "jdbc:mysql://localhost:3306/library_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = env.get("DB_USER");
    private static final String PASSWORD = env.get("DB_PASS");

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // modern driver for Connector/J 9.x
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found!");
            e.printStackTrace();
        }
        System.out.println("Connecting with user: " + USER); // Debug print
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
