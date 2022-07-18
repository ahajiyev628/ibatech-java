package lesson6;

class Pizza {
  String name;
  Integer size;

  public Pizza(String n, Integer s) {
    this.name = n;
    this.size = s;
  }

  public void printMe() {
    System.out.printf(
      "Pizza name %s of size %d\n",
      name, size);
  }
}

public class PizzaApp {

  static void doSomething(Pizza p) {
//    p.name;
//    p.size;


  }

  public static void main(String[] args) {
    Pizza p1 = new Pizza("Quattroformaggi", 30);
    Pizza p2 = new Pizza("Margarita", 60);

    p1.printMe();
    p2.printMe();
  }

}
