package lesson12;

import java.util.Arrays;

public class SortingComparable {

  static class Pizza implements Comparable<Pizza>{
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

    @Override
    public int compareTo(Pizza that) {
//      return this.name.compareTo(that.name);
//      return this.size - that.size;
      return (int)((this.weight - that.weight) * 100);
    }
  }

  public static void main(String[] args) {
    Pizza[] ps = {
        new Pizza(1.05, 60, "Margarita"),
        new Pizza(1.03, 60, "Cheese"),
        new Pizza(1.01, 30, "QuattroFormagio")
    };
    Arrays.sort(ps);
    for (Pizza p: ps) {
      System.out.println(p);
    }
  }

}
