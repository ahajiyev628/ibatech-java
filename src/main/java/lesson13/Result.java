package lesson13;

public class Result {
  public final Interval interval;
  public final int count;

  public Result(Interval interval, int count) {
    this.interval = interval;
    this.count = count;
  }

  public static Result of(Interval interval, int count) {
    return new Result(interval, count);
  }

}
