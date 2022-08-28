package lesson16.dao;

import java.io.Serializable;

public class Student implements Serializable, Identifiable {
  int id;
  String name;
  String group;

  public Student(int id, String name, String group) {
    this.id = id;
    this.name = name;
    this.group = group;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", group='" + group + '\'' +
        '}';
  }

  @Override
  public int id() {
    return this.id;
  }
}
