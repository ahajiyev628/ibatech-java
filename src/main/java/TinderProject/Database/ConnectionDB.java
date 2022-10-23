package TinderProject.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static final String url = "jdbc:postgresql://localhost:5432/abbtech";
    public static final String username = "ahajiyev";
    public static final String password = "Gltsry1905!";
    public static  String dbDriver = "org.postgresql.Driver";
    public static final Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(ConnectionDB.url,
                    ConnectionDB.username,
                    ConnectionDB.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
