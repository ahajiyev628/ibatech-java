package lesson9;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true
 */
public class DiagonalDifferenceV1 implements DiagonalDifference {

  @Override
  public int diagonalDifference(List<List<Integer>> data) {
    int size = data.size();

    // diagonal 1
    int sum1 = 0;
    for (int i = 0; i < size; i++) {
      sum1 += data.get(i).get(i);
    }
    // diagonal 2
    int sum2 = 0;
    for (int i = 0; i < size; i++) {
      sum2 += data.get(i).get(size - i - 1);
    }

    return Math.abs(sum1 - sum2);
  }

}
