package lesson9;

import java.util.*;

public class CollectionSet2 {

  public static void main(String[] args) {
    Set<Pizza> ps = new HashSet<>();
    String[] ig = new String[]{};
    ps.add(new Pizza(30, "M", ig));
    ps.add(new Pizza(60, "A", ig));
    ps.add(new Pizza(60, "A", ig));
    System.out.println(ps.size());
  }

}
