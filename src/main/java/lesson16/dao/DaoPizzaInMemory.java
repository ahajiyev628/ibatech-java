
package lesson16.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DaoPizzaInMemory implements DaoPizza {

  private Map<Integer, Pizza> data = new HashMap<>();

  public void save(Pizza p) {
    data.put(0, p); // WRONG
  }

  public Optional<Pizza> load(int id) {
    throw new IllegalArgumentException("not implemented");
  }

}
