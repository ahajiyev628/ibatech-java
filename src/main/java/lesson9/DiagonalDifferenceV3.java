package lesson9;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem?isFullScreen=true
 */
public class DiagonalDifferenceV3 implements DiagonalDifference {

  @Override
  public int diagonalDifference(List<List<Integer>> data) {
    int size = data.size();

    int sum = 0;
    for (int i = 0; i < size; i++) {
      List<Integer> row = data.get(i);
      sum = sum + row.get(i) - row.get(size - i - 1);
    }

    return Math.abs(sum);
  }

}
