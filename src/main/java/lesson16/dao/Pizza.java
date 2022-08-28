package lesson16.dao;

import java.io.Serializable;

public class Pizza implements Serializable, Identifiable {
  int id;
  int size;

  public Pizza(int id, int size) {
    this.id = id;
    this.size = size;
  }

  @Override
  public String toString() {
    return "Pizza{" +
        "size=" + size +
        '}';
  }

  @Override
  public int id() {
    return this.id;
  }
}
