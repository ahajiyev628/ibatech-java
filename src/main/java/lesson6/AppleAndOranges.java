package lesson6;

import java.util.List;

/** https://www.hackerrank.com/challenges/apple-and-orange/problem */
public class AppleAndOranges {

  public static int[] convertToArray(List<Integer> xs) {
    return xs.stream().mapToInt(a -> a).toArray();
  }

  static boolean inTheRange(int pos, int l, int r) {
    return pos >= l && pos <= r;
  }

  public static void countApplesAndOranges(
    int s, // house position L
    int t, // house position R
    int a, // apple position
    int b, // orange position
    List<Integer> apples0, // apples distances
    List<Integer> oranges0 // oranges distances
  ) {
    int[] apples = convertToArray(apples0);
    int[] oranges = convertToArray(oranges0);
    int ac = 0;
    int oc = 0;
    // count apples
    for (int i = 0; i < apples.length; i++) {
      int pos = a + apples[i];
      if (inTheRange(pos, s, t)) ac++;
    }
    // count oranges
    for (int orange: oranges) {
      int pos = b + orange;
      if (inTheRange(pos, s, t)) oc++;
    }
    System.out.println(ac);
    System.out.println(oc);
  }

}
