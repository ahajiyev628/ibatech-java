package lesson11;

public class Triple<A, B, C> {
  public A a;
  public B b;
  public C c;

  public Triple(A a, B b, C c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public static <A, B, C> Triple<A, B, C> of(A a, B b, C c) {
    return new Triple<>(a, b, c);
  }

}