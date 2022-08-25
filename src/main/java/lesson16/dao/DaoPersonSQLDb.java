package lesson16.dao;

import java.sql.Connection;

public class DaoPersonSQLDb implements DaoPerson {

  private final Connection sqlConnection;

  public DaoPersonSQLDb(Connection sqlConnection) {
    this.sqlConnection = sqlConnection;
  }

  @Override
  public void save(Person p) {
    throw new IllegalArgumentException("not implemented");
  }

  @Override
  public Person load(int id) {
    throw new IllegalArgumentException("not implemented");
  }

}
