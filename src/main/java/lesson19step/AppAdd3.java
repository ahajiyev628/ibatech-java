package lesson19step;

import java.io.File;
import java.util.Arrays;

public class AppAdd3 {

  public static int add(int x, int y) {
    return x + y;
  }

  public static void doTheBusinessWithConsole(Console console) {
    int x = Integer.parseInt(console.nextLine());
    int y = Integer.parseInt(console.nextLine());
    int z = add(x, y);
    console.printLine("" + z);
  }

  public static void mainR(String[] args) {
    Console c = new RealConsole();

    doTheBusinessWithConsole(c);
  }

  public static void mainT1(String[] args) {
    TestConsole c = new TestConsole(Arrays.asList("5", "6")); // test input

    doTheBusinessWithConsole(c);

    boolean contains = c.output.contains("11"); // expected output
    System.out.println(contains);
  }

  public static void mainT2(String[] args) {
    TestConsole c = new TestConsole(new File("test-input.txt")); // test input

    doTheBusinessWithConsole(c);

    boolean contains = c.output.contains("11"); // expected output
    System.out.println(contains);
  }

  public static void main(String[] args) {
//    mainR(args);
    mainT2(args);
  }

}
