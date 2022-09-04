package lesson19step;

import java.util.ArrayList;

/** can I test? yes */
public class App2 {

  static void printMenu(Console console) {
    console.printLine("======");
    console.printLine("1.Show");
    console.printLine("2.Book");
    console.printLine("======");
  }

  public static void mainTest(String[] args) {
    TestConsole c = new TestConsole(new ArrayList<>());
    printMenu(c);
    boolean contains = c.output.contains("1.Show");
    System.out.println(contains);
  }

  public static void main(String[] args) {
    Console c = new RealConsole();
    printMenu(c);
  }

}
