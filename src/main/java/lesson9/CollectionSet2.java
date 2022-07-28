package lesson9;

import java.util.HashSet;
import java.util.Set;

public class CollectionSet2 {

  static class Pizza {
    final int size;
    Pizza(int size) {
      this.size = size;
    }
  }

  public static void main(String[] args) {
    Set<Pizza> ps = new HashSet<>();
    ps.add(new Pizza(30));
    ps.add(new Pizza(60));
    ps.add(new Pizza(60));
    System.out.println(ps.size());
  }

}
