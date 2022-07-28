package lesson9;

import java.util.ArrayList;

public class CollectionsList {

  public static void printMe(Integer x) {
    System.out.println(x);
  }

  public static void main(String[] args) {
    ArrayList<Integer> as = new ArrayList<Integer>();
    as.add(11); // 11
    as.add(12); // 11, 12
    as.add(2);  // 11, 12, 2
    as.add(30); // 11, 12, 2, 30
    as.forEach(x -> printMe(x));
//    as.remove(0); // 12, 2, 30
//    Integer item1 = as.get(1);// 2
//    int     item2 = as.get(1);// 2
//    int s = as.size();
//    // each type has brother
//    int x;
//    Integer x1;
//    long y;
//    Long y1;

  }
}
