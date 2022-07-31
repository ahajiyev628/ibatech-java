package lesson10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumbers {

  public static int nextInt() {
    return (int)(Math.random()*10+1);
  }

  // 7 random numbers in range 1..10
  public static List<Integer> randomsNonUnique(int number) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < number; i++) {
      result.add(nextInt());
    }
    return result;
  }

  // 7 random UNIQUE numbers in range 1..10
  public static Set<Integer> randomsUnique(int number) {
    HashSet<Integer> result = new HashSet<>();
    while (result.size() < number) {
      result.add(nextInt());
    }
    return result;
  }

  // 7 random numbers in range 1..10
  public static void main(String[] args) {
    System.out.println(randomsNonUnique(7));
    System.out.println(randomsUnique(7));
  }


}
