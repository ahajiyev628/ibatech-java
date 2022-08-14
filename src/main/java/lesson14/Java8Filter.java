package lesson14;

import lesson6.Pizza;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Filter {

  public static List<Integer> onlyNegatives(List<Integer> xs) {
    List<Integer> out = new ArrayList<Integer>();
    xs.forEach(x -> {
      if (x < 0) out.add(x);
    });
    return out;
  }

  public static List<Integer> onlyNegatives2(List<Integer> xs) {
    return
        xs.stream()
            .filter(x -> x < 0)
            .collect(Collectors.toList());
  }

  public static void main1(String[] args) {
    List<Integer> xs = Arrays.asList(1, -2, 3, -4);
    List<Integer> neg = onlyNegatives(xs);
    System.out.println(neg);
  }

  public static void main(String[] args) {
    List<Integer> collect1 = Arrays.asList(1, 2, 3)
        .stream()
        .map(x -> x + 10)
        .collect(Collectors.toList()); // 11, 12, 13

    Set<Integer> collect2 = Arrays.asList(1, 2, 1)
        .stream()
        .map(x -> x + 10)
        .collect(Collectors.toSet()); // 11, 12

    List<Integer> collect3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .stream()
        .limit(3)
        .collect(Collectors.toList()); // 1, 2, 3

    List<Integer> collect4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .stream()
        .skip(2)
        .collect(Collectors.toList()); // 3, 4, 5, 6, 7, 8, 9, 10

    List<String> xx = Arrays.asList(1, 2, 3)
        .stream()
        .map(x -> x + 30)
        .map(x -> new Pizza("Margarita", x))
        .filter(p -> p.size > 31)
//        .parallel()
        .map(p -> p.name)
        .distinct()
        .map(n -> n.toUpperCase())
        .collect(Collectors.toList());

    Map<Boolean, List<Integer>> collect5 = Stream.generate(() -> Math.random())
        .map(x -> (int) (x * 100))
        .limit(30)
        .collect(Collectors.partitioningBy(x -> x < 0));

    Map<Integer, List<Integer>> collect = Stream.generate(() -> Math.random())
        .map(x -> (int) (x * 100))
        .limit(30)
        .collect(Collectors.groupingBy(x -> x / 10));


    System.out.println(collect);

  }

}
