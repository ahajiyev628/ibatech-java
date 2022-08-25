package last;

import java.util.LinkedList;

public class LatItem {

  public LinkedList<Integer> convert(int[] xs) {
    LinkedList<Integer> data = new LinkedList<>();
    for (int x: xs) data.add(x);
    return data;
  }

  public int last(int[] data0) {
    LinkedList<Integer> data = convert(data0);
    while (data.size() >=2) {
      int x1 = data.removeFirst();
      int x2 = data.removeFirst();
      int sum = x1 + x2;
      int item = sum % 2 == 0 ? sum : Math.abs(x1 - x2);
      data.add(item);
    }
    return data.removeFirst();
  }


}
