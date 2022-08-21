package lesson15;

import lesson9.Pizza;

import java.rmi.server.UnicastRemoteObject;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPredicates {

  // all elements > 0
  public boolean something1(int[] xs, Predicate<Integer> p) {
    for (int x: xs) {
      if (!p.test(x)) return false;
    }
    return true;
  }

  // NONE elements > 0
  public boolean something2(int[] xs, Predicate<Integer> p) {
    for (int x: xs) {
      if (p.test(x)) return false;
    }
    return true;
  }

  // AT least one element > 0
  public boolean something3(int[] xs, Predicate<Integer> p) {
    for (int x: xs) {
      if (p.test(x)) return true;
    }
    return false;
  }

  public static void main0(String[] args) {
    System.out.println(
        IntStream.range(1, 10)
        .noneMatch(x -> x < 0)
    );
    System.out.println(
        IntStream.range(1, 10)
        .allMatch(x -> x > 0)
    );
    System.out.println(
        IntStream.range(1, 10)
        .anyMatch(x -> x > 0)
    );
    System.out.println(
        IntStream.range(1, 10)
        .anyMatch(x -> x < 0)
    );
  }

  public static void main(String[] args) {

    Stream<Pizza> ps = null;
    boolean allPizzaGreaterThan30 = ps.allMatch(p -> p.size > 30);

  }

}
