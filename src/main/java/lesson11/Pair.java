package lesson11;

public class Pair<A, B> {
  public A a;
  public B b;

  public Pair(A key, B value) {
    this.a = key;
    this.b = value;
  }

  @Override
  public String toString() {
    return String.format("(%s, %s)", a, b);
  }

  public static <A, B> Pair<A, B> of(A key, B value) {
    return new Pair<>(key, value);
  }

}