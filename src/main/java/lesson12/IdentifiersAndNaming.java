package lesson12;

public class IdentifiersAndNaming {

  class Person {}
  class Pager {}
  class User {}
  class Role {}
  enum Size {}
  class Box {}

  public static void main(String[] args) {
    // okay, perfect
    // they are the same type
    // I need to use proper naming to provide more semantics
    int weight;
    int height;
    int low;
    int high;
    int pos;
    int index;

    // do you need full names ??? - we don't.
    Box box;
    Size size;
    Person person;
    Role role;
    User user;

    // ok, even better
    // all of them of their proper types
    // semantics provided by type (class name)
    Box b;
    Size s;
    Person p;
    Role r;
    Role rMain;
    User u;
    Pager pg;
  }
}
