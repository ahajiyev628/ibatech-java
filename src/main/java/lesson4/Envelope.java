package lesson4;

public class Envelope {

  public static void main(String[] args) {
    int height = 8;
    int width = 22;
    double k = (double) width / height;

    final int firstRow = 0;
    final int firstCol = 0;
    final int lastRow = height - 1;
    final int lastCol = width - 1;

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (row == firstRow ||
            col == firstCol ||
            col == lastCol ||
            row == lastRow ||
            Math.round(row * k) == col
        )
          System.out.print("*");
        else System.out.print(" ");
      }
      System.out.println();
    }
  }

}
