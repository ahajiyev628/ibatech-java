package lesson13;

public class Interval {
  public final int low;
  public final int hi;

  public Interval(int low, int hi) {
    this.low = low;
    this.hi = hi;
  }

  public boolean contains(Interval sub) {
    return low <= sub.low
        && hi >= sub.hi;
  }

  @Override
  public String toString() {
    return String.format("[%d - %d]", low, hi);
  }

  public static Interval of(int a, int b) {
    return new Interval(a, b);
  }
}
