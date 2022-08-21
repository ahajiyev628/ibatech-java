package lesson15;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {

  public static int min0(int[] xs) throws NoSuchElementException {
    throw new NoSuchElementException();
  }

  public static Optional<Integer> min1(List<Integer> xs) {
    if (xs.isEmpty()) {
      return Optional.empty();
    } else {
      int m = Integer.MAX_VALUE;
      for (int x: xs) {
        m = Math.min(m, x);
      }
      return Optional.of(m);
    }
  }

  public static void main0(String[] args) {
    // hard
    try {
      int i = min0(new int[]{});
    } catch (NoSuchElementException x) {
      //...
    }

    Optional<Integer> r1 = min1(Arrays.asList(1, 3)); // 1
    Optional<Integer> r2 = min1(Arrays.asList());     // empty

  }

  public static Optional<Integer> toInt(String s) {
    try {
      int value = Integer.parseInt(s);
      return Optional.of(value);
    } catch (NumberFormatException x) {
      return Optional.empty();
    }
  }

  public static void main1(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();
//    int x = Integer.parseInt(line);
    Optional<Integer> x = toInt(line);
    Optional<Integer> x2 = x.map(a -> a + 1);
    System.out.println(x2);



  }

  public static Optional<String> construct(String s) {
    // if we DO NOT know about null / not null
    Optional<String> os = Optional.ofNullable(s);
    //                             ==========
    return os;
  }


  public static void main2(String[] args) {
    // if we know 100% value is nit null
    Optional<String> os = Optional.of("Jim");
    //                             ==
    System.out.println(construct(null));


  }

  public static void main3(String[] args) {
    Optional<String> ox =
        Optional.of(5)                    // Optional<Integer>(10)
        .map(x -> x + 1)                        // Optional<Integer>(11)
        .map(x -> String.format("<< %d >>", x)) // Optional<String>("<< 11 >>")
        .filter(x -> x.length() > 7);// Optional.empty
    System.out.println(ox);

    // in the end
    if (ox.isPresent()) {
      ox.get();
    }
    if (ox.isEmpty()) {
      ox.get(); // NPX
    }

  }

  public static void main(String[] args) {
    List<String> data = Arrays.asList(
        "1",
        "5",
        "sadmnfb",
        "sadm",
        "33",
        "15",
        "1q"
    );
    List<Integer> numbers = data.stream().map(s -> toInt(s))
        .filter(x -> x.isPresent())
        .map(x -> x.get())
        .collect(Collectors.toList());
    System.out.println(numbers);
  }

}
