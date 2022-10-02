package lesson23sql1;

import java.sql.ResultSet;
import java.sql.SQLException;

class Person {
  int id;
  String name;

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  static Person fromResultSet(ResultSet rs) throws SQLException {
    return new Person(
        rs.getInt("id"),
        rs.getString("name")
    );
  }

  @Override
  public String toString() {
    return String.format("Person : %d : %s", id, name);
  }
}
