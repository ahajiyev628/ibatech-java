package lesson19step;

import java.util.Scanner;

public class RealConsole implements Console {

  private Scanner scanner = new Scanner(System.in);

  @Override
  public String nextLine() {
    return scanner.nextLine();
  }

  @Override
  public void printLine(String line) {
    System.out.println(line);
  }
}
