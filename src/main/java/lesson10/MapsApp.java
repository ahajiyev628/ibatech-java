package lesson10;

import lesson9.Pizza;

import java.util.HashMap;

public class MapsApp {

  public static void main(String[] args) {
    HashMap<Integer, Pizza> map = new HashMap<>();
    map.put(1, new Pizza(30, "Margarita"));
    map.put(2, new Pizza(40, "Margarita"));
    map.put(3, new Pizza(40, "QuattroFormaggio"));
    map.put(4, new Pizza(60, "QuattroFormaggio"));

    System.out.println(map.get(1));
    System.out.println(map.get(2));

  }
}
