package lesson14;

import lesson6.Pizza;
import lesson6.PizzaApp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PizzaUsecase {

  public static void main(String[] args) {
    List<Pizza> pizzas = Arrays.asList(
        new Pizza("Margarita", 60),
        new Pizza("Margarita", 40),
        new Pizza("Margarita", 30),
        new Pizza("Margarita", 31)
    );

    List<Pizza> collect = pizzas.stream()
        .filter(p -> p.size > 30)
        .collect(Collectors.toList());

  }

}
