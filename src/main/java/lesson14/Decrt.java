package lesson14;

import lesson11.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Decrt {

  public static void main(String[] args) {

    List<Integer> ages = Arrays.asList(22, 24, 26, 30, 44, 50);
    List<String> names = Arrays.asList("Jim", "Sergio", "Bill", "Name");

    ages.stream()
        .flatMap(a ->
            names.stream().map(n -> Pair.of(n, a))
        )
        .filter(p -> p.b > 40)
        .forEach(System.out::println);

    // Optional
    //  - Optional.of(...) === Stream of 1 element
    //  - Optional.empty   === Stream.empty

    Optional<Integer> first = ages.stream() // Stream<Integer>
        .filter(x -> x < 0)
        .findFirst();


  }
}
