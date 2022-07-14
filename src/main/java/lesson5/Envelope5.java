package lesson5;


/*
 ************************
 ************************
 **  *              *  **
 **     *        *     **
 **       *    *       **
 **         X          **
 **      *      *      **
 **   *            *   **
 ************************
 ************************

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
                if (row == firstRow ||                   // firstRow
                        row == firstRow + 1 ||
                        col == firstCol ||
                        col == firstCol + 1||                   // firstCol
                        col == lastCol ||                    // lastCol
                        row == lastRow ||                     // firstCol
                        col == lastCol - 1||                    // lastCol
                        row == lastRow - 1||                    // lastRow
                        col == Math.round(row * k) ||        // diagonal 1
                        col == lastCol - Math.round(row * k) // diagonal 2
                )
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        /** input data */
        int height = 12;
        int width = 22;

        /** call the business logic extracted and decoupled from input and output */
        String result = makeEnvelope(width, height);

        /** output result */
        System.out.println(result);
    }

}
