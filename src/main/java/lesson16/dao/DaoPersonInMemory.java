package lesson16.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DaoPersonInMemory implements DaoPerson {

  private final Map<Integer, Person> map = new HashMap<>();

  @Override
  public void save(Person p) {
    map.put(p.id, p);
  }

  @Override
  public Optional<Person> load(int id) {
    return Optional.ofNullable(map.get(id));
  }

}
