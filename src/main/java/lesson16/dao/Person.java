package lesson16.dao;

import java.io.Serializable;

public class Person implements Serializable, Identifiable {
  String name;
  int id;

  public Person(String name, int id) {
    this.name = name;
    this.id = id;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", id=" + id +
        '}';
  }

  @Override
  public int id() {
    return this.id;
  }
}
