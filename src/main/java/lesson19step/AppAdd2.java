package lesson19step;

public class AppAdd2 {

  public static int add(int x, int y) {
    return x + y;
  }

  public static void main(String[] args) {
    Console c = new RealConsole();
    int x = Integer.parseInt(c.nextLine());
    int y = Integer.parseInt(c.nextLine());
    int z = add(x, y);
    System.out.println(z);
  }
}
