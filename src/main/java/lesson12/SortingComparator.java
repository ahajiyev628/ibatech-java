package lesson12;

import java.util.Arrays;
import java.util.Comparator;

public class SortingComparator {

  static class Pizza {
    double weight;
    int size;
    String name;

    public Pizza(double weight, int size, String name) {
      this.weight = weight;
      this.size = size;
      this.name = name;
    }

    public String toString() {
      return String.format("Pizza{weight=%f, size=%d, name='%s'}", weight, size, name);
    }

    public static final Comparator<Pizza> cmpByName0 = new Comparator<Pizza>() {
      @Override
      public int compare(Pizza o1, Pizza o2) {
        return o1.name.compareTo(o2.name);
      }
    };
    public static final Comparator<Pizza> cmpByName1 =
        (Pizza o1, Pizza o2) -> { return o1.name.compareTo(o2.name); };
    public static final Comparator<Pizza> cmpByName2 =
        (p1, p2) -> { return p1.name.compareTo(p2.name); };
    public static final Comparator<Pizza> cmpByName3 =
        (p1, p2) -> p1.name.compareTo(p2.name);
    public static final Comparator<Pizza> cmpByName =
        Comparator.comparing(p -> p.name);

    public static final Comparator<Pizza> cmpByWeight = Comparator.comparingDouble(p -> p.weight);
    public static final Comparator<Pizza> cmpBySize = Comparator.comparingInt(p -> p.size);

  }

  public static void main(String[] args) {
    Pizza[] ps = {
        new Pizza(1.05, 60, "Margarita"),
        new Pizza(1.03, 60, "Cheese"),
        new Pizza(1.01, 30, "QuattroFormagio")
    };

    Arrays.sort(ps, Pizza.cmpByName);
    for (Pizza p: ps) {
      System.out.println(p);
    }
    System.out.println("--");
    Arrays.sort(ps, Pizza.cmpBySize);
    for (Pizza p: ps) {
      System.out.println(p);
    }
    System.out.println("--");
    Arrays.sort(ps, Pizza.cmpByWeight);
    for (Pizza p: ps) {
      System.out.println(p);
    }
  }

}
