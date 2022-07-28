package lesson9;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true
 */
public class DiagonalDifferenceV2 implements DiagonalDifference{

  @Override
  public int diagonalDifference(List<List<Integer>> data) {
    int size = data.size();

    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i < size; i++) {
      List<Integer> row = data.get(i);
      sum1 += row.get(i);
      sum2 += row.get(size - i - 1);
    }

    return Math.abs(sum1 - sum2);
  }

}
