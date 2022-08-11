package lesson13;

import java.util.Iterator;

public class MyBlackBox implements Iterable<String> {

  private String[] data = {"jan", "feb", "mar"};

  @Override
  public Iterator<String> iterator() {

    Iterator<String> it = new Iterator<>() {

      int pos = 0;

      @Override
      public boolean hasNext() {
        return pos < data.length;
      }

      @Override
      public String next() {
        String x = data[pos];
        pos++;
        return x;
      }

    };

    return it;
  }
}
