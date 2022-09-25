package lesson22web;

public class Student {

  String name;
  Integer age;
  String group;

  public Student(String name, Integer age, String group) {
    this.name = name;
    this.age = age;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public String getGroup() {
    return group;
  }
}
