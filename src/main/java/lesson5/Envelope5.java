package lesson5;


/*
  01234567...
0 ************************
1 ************************
2 **  *              *  **
3 **     *        *     **
4 **       *    *       **
5 **         X          **
6 **      *      *      **
7 **   *            *   **
8 ************************
9 ************************

 *
 * */
public class Envelope5 {

    public static String makeEnvelope(int width, int height) {
        /** logic / process */
        double k = (double) width / height;

        final int firstRow = 0;
        final int firstCol = 0;
        final int lastRow = height - 1;
        final int lastCol = width - 1;

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
              if (row == lastRow / 2 && col == lastCol / 2)
                sb.append("X");
              else if (row == firstRow ||                   // firstRow
                  row == firstRow + 1 ||
                  col == firstCol ||
                  col == firstCol + 1||                   // firstCol
                  col == lastCol ||                    // lastCol
                  row == lastRow ||                     // firstCol
                  col == lastCol - 1||                    // lastCol
                  row == lastRow - 1||                    // lastRow
                  col == Math.round(row * k) ||        // diagonal 1
                  col == lastCol - Math.round(row * k) // diagonal 2
              ) sb.append("*");
              else sb.append(" ");
            }
          sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        /** input data */
        int height = 13;
        int width = 23;

        /** call the business logic extracted and decoupled from input and output */
        String result = makeEnvelope(width, height);

        /** output result */
        System.out.println(result);
    }

}
