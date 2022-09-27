package lesson23sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnectionOnly {

  public static void main(String[] args) throws SQLException {
    Connection conn = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/be5",
        "postgres",
        "pg123456"
    );
  }


}
