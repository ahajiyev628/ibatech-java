package lesson17.autoclosable;

import java.io.Closeable;

public class MySuperFunctionality implements Closeable {
  //                                         ^^^^^^^^^

  @Override
  public void close() {
    System.out.println("closing automatically...");
  }

}
