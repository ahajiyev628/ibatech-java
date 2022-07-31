package lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ListFiltering {

  public static List<Integer> filterNegative(List<Integer> data) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int x: data) {
      if (x < 0) result.add(x);
    }
    return result;
  }

  public static List<Integer> filterNegativeExplanation(List<Integer> data) {
    ArrayList<Integer> result = new ArrayList<>();

    class NegativeProcessor implements Consumer<Integer> {
      @Override
      public void accept(Integer x) {
        if (x < 0) result.add(x);
      }
    }

    NegativeProcessor np = new NegativeProcessor();

    data.forEach(x -> np.accept(x));

    return result;
  }

  public static List<Integer> filterNegativeV2(List<Integer> data) {
    ArrayList<Integer> result = new ArrayList<>();
    data.forEach(x -> {
      if (x < 0) result.add(x);
    });
    return result;
  }

  public static List<Integer> filterPositive(List<Integer> data) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      int x = data.get(i);
      if (x > 0) result.add(x);
    }
    return result;
  }

  public static void main(String[] args) {
    List<Integer> data = Arrays.asList(1, 4, -7, -11, 3, 8, -3);
    System.out.println(filterNegative(data));
    System.out.println(filterPositive(data));
  }

}
