package lesson14;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Java8 {

  public static void printer2(Integer x){
    System.out.printf("Value is: %d", x);
  }

  public static void main(String[] args) {
    List<Integer> xs = Arrays.asList(1, 2, 3);

    Consumer<Integer> printer = new Consumer<>() {
      @Override
      public void accept(Integer x) {
        System.out.printf("Value is: %d", x);
      }
    };

    Consumer<Integer> printer32 = (Integer x) -> {
      System.out.printf("Value is: %d", x);
    };

    Consumer<Integer> printer31 = (Integer x) -> System.out.printf("Value is: %d", x);

    Consumer<Integer> printer3 = x -> System.out.printf("Value is: %d", x);

    xs.forEach(x -> printer.accept(x));
    xs.forEach(printer);

    xs.forEach(x -> System.out.println(x));
    xs.forEach(System.out::println); // reference to class member
    xs.forEach(Java8::printer2);
  }
}
