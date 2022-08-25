package lesson16.dao;

import java.util.HashMap;
import java.util.Map;

public class DaoPersonInMemory implements DaoPerson {

  private final Map<Integer, Person> map = new HashMap<>();

  @Override
  public void save(Person p) {
    throw new IllegalArgumentException("not implemented");
  }

  @Override
  public Person load(int id) {
    throw new IllegalArgumentException("not implemented");
  }

}
