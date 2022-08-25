
package lesson16.dao;

public class DaoPizzaInMemory implements DaoPizza {

  public void save(Pizza p) {
    throw new IllegalArgumentException("not implemented");
  }

  public Pizza load(int id) {
    throw new IllegalArgumentException("not implemented");
  }

}
