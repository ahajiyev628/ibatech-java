package lesson17.binaryfile;

import java.io.Serializable;

public class Pizza implements Serializable {

  int size;

  public Pizza(int size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "Pizza{" +
        "size=" + size +
        '}';
  }

}
