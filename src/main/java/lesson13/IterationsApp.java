package lesson13;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class IterationsApp {

  interface My extends Iterable<Integer> {

    default void myForEach(Consumer<Integer> cns) {
//      for (int x : this) {
//        cns.accept(x);
//      }
      Iterator<Integer> it = iterator();
      while (it.hasNext()) {
        int x = it.next();
        cns.accept(x);
      }
    }


  }




  public void doProcess(List<Interval> data) {

  }



  public static void main(String[] args) {
    List<Integer> as = Arrays.asList(1, 2, 3);
    /// sugar
    for (Integer a: as) {
      System.out.println(a);
    }
    /// full syntax
    Iterator<Integer> it = as.iterator();
    while (it.hasNext()) {
      int x = it.next();
      System.out.println(x);
    }

    MyBlackBox box = new MyBlackBox();
    Iterator<String> it2 = box.iterator();
    while (it2.hasNext()) {
      String x = it2.next();
      System.out.println(x);
    }

    it2 = box.iterator();
    while (it2.hasNext()) {
      String x = it2.next();
      System.out.println(x);
    }

    for (String month: box) {
      System.out.println(month);
    }
  }
}
