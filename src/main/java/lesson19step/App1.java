package lesson19step;

/** can I test?: no / possible */
public class App1 {

  static void printMenu(Console console) {
    console.printLine("Hello");
  }

  public static void main(String[] args) {
    Console c = new RealConsole();
    printMenu(c);
  }

}
