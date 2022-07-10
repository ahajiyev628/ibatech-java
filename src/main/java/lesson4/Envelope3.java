package lesson4;

public class Envelope3 {

  public static String makeEnvelope(int width, int height) {
    /** logic / process */
    double k = (double) width / height;

    final int firstRow = 0;
    final int firstCol = 0;
    final int lastRow = height - 1;
    final int lastCol = width - 1;

    String result = "";
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (row == firstRow ||                   // firstRow
            col == firstCol ||                   // firstCol
            col == lastCol ||                    // lastCol
            row == lastRow ||                    // lastRow
            col == Math.round(row * k) ||        // diagonal 1
            col == lastCol - Math.round(row * k) // diagonal 2
        )
          result = result + "*";
        else result = result + " ";
      }
      result = result + "\n";
    }
    return result;
  }

  public static void main(String[] args) {
    /** input data */
    int height = 8;
    int width = 22;

    /** call the business logic extracted and decoupled from input and output */
    String result = makeEnvelope(width, height);

    /** output result */
    System.out.println(result);
  }

}
