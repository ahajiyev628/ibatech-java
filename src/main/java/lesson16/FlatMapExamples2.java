package lesson16;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExamples2 {

  public static void main(String[] args) {
    List<Integer> collected1 = List.of(1, 2, 3).stream()
        .flatMap(x -> Stream.of(x, x))
        .collect(Collectors.toList());
    System.out.println(collected1);

    List<Integer> collected2 = List.of(1, 2, 3).stream()
        .flatMap(x -> Stream.of(x, x+1))
        .flatMap(x -> Stream.of(x, -x))
        .flatMap(x -> Stream.of(x, x*10))
        // filter implementation
        .flatMap(x -> {
          if (x > 0) return Stream.of(x); else return Stream.of();
        })
        .collect(Collectors.toList());
    System.out.println(collected2);
  }



}
