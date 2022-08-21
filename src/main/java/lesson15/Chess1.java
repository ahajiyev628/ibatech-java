package lesson15;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Chess1 {

  public static IntStream Ito8(){
    return IntStream.rangeClosed(1, 8);
  }

  static Stream<Pos> right(Pos p) {
    //     1..8
    return Ito8().mapToObj(dx -> p.move(dx, 0));
  }

  static Stream<Pos> left(Pos p) {
    //     1..8
    return Ito8().mapToObj(dx -> p.move(-dx, 0));
  }

  static Stream<Pos> up(Pos p) {
    //     1..8
    return Ito8().mapToObj(dy -> p.move(0, dy));
  }

  static Stream<Pos> down(Pos p) {
    //     1..8
    return Ito8().mapToObj(dy -> p.move(0, -dy));
  }

  static Stream<Pos> allVerHor(Pos p0) {
    return Stream.of(right(p0), left(p0), up(p0), down(p0))
        .flatMap(a -> a)
        .filter(p -> p.isOnBoard());
  }
  // left + right + up + down
  public static List<Pos> nextRook(Pos p0) {
    return allVerHor(p0)
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    System.out.println(nextRook(Pos.of("e4")));
  }

}
