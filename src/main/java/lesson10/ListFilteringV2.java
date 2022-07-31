package lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ListFilteringV2 {

  /**
   * it works for negative / positive numbers
   * BUT: what if: x % 2 == 0, x == 0, ...
   */
  public static List<Integer> filterList(List<Integer> arr, boolean isPositive){
    List<Integer> resArr = new ArrayList<>();
    arr.forEach(item -> {
      if(item!=0 && (item>0) == isPositive)
        resArr.add(item);
    });
    return resArr;
  }

  interface FilterFn extends Predicate<Integer> { }

  public static List<Integer> filter(List<Integer> data, FilterFn fn) {
    ArrayList<Integer> result = new ArrayList<>();
    data.forEach(x -> {
      if (fn.test(x)) result.add(x);
    });
    return result;
  }

  public static boolean gt(Integer x) {
    return x > 0;
  }

  public static void main(String[] args) {
    List<Integer> data = Arrays.asList(1, 4, -7, -11, 3, 8, -3);

    List<Integer> filtered1 = filter(data, new FilterFn() {
      @Override
      public boolean test(Integer x) {
        return x > 0;
      }
    });
    List<Integer> filtered2 = filter(data, (Integer x) -> x > 0);
    List<Integer> filtered3 = filter(data,          x  -> x > 0);
    List<Integer> filtered4 = filter(data,          x -> gt(x));
    List<Integer> filtered5 = filter(data,          ListFilteringV2::gt);

    System.out.println(filter(data, x -> x > 0));
    System.out.println(filter(data, x -> x < 0));
  }

}
