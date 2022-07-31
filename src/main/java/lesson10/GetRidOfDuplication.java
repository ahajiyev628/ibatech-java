package lesson10;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lesson10.RandomNumbers.randomsNonUnique;

public class GetRidOfDuplication {

  public static void main(String[] args) {
    List<Integer> randoms = randomsNonUnique(20);
    System.out.println(randoms);
    Set<Integer> randomsUnique = new HashSet<>(randoms);
    System.out.println(randomsUnique);

    randoms.forEach(x -> System.out.printf("%d ", x));
    randomsUnique.forEach(x -> System.out.printf("%d ", x));
  }

}
