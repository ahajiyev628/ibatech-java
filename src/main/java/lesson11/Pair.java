package lesson11;

public class Pair<A, B> {
  A a;
  B b;

  public Pair(A key, B value) {
    this.a = key;
    this.b = value;
  }

  static <A, B> Pair<A, B> of(A key, B value) {
    return new Pair<>(key, value);
  }

}