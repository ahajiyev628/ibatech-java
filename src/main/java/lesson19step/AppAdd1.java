package lesson19step;

import java.util.Scanner;

public class AppAdd1 {

  public static int add(int x, int y) {
    return x + y;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = Integer.parseInt(scanner.nextLine());
    int y = Integer.parseInt(scanner.nextLine());
    int z = add(x, y);
    System.out.println(z);
  }
}
