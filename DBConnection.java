import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library_db?useSSL=false";
    private static final String USER = "thavha";
    private static final String PASSWORD = "mypassword";

   public static Connection getConnection() throws SQLException {
    try {
        Class.forName("com.mysql.jdbc.Driver"); // for Connector/J 5.1
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return DriverManager.getConnection(URL, USER, PASSWORD);
}

}

