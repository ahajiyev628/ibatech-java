package lesson11;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericsApp {

  static class BoxInt {
    Integer value;

    public BoxInt(Integer value) {
      this.value = value;
    }
  }

  static class BoxString {
    String value;

    public BoxString(String value) {
      this.value = value;
    }
  }

  static class BadBox {
    Object value;

    public BadBox(Object value) {
      this.value = value;
    }
  }

  static class Box<A> {
    A value;

    public Box(A value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.format("Box with %d", value);
    }
  }

  public static void main(String[] args) {
    BadBox b1 = new BadBox(5);
    BadBox b2 = new BadBox("Jim");
    BadBox b3 = new BadBox(true);
    Object x = b1.value;


    Box<Integer> box1 = new Box<Integer>(5);
    Integer x1 = box1.value;

    Box<Double> box2 = new Box<Double>(3.14);
    Double x2 = box2.value;

    //    new ArrayList<Integer>();
//    new ArrayList<String>();
//    new ArrayList<Pair<Integer, Double>>();
//
    new BoxInt(5);
//    new BoxInt(true);
    new BoxString("Jim");
//    new BoxString(3.15);

    Box<Pair<Integer, String>> box31 = new Box<>(Pair.of(44, "Alex"));
    Box<Pair<Integer, String>> box32 = new Box<>(new Pair<>(44, "Alex"));

    ArrayList<Box<Integer>> boxes = new ArrayList<>();
    boxes.add(new Box<>(1));
    boxes.add(new Box<>(5));
    boxes.add(new Box<>(3));
    boxes.forEach(b -> System.out.println(b));

    Comparator<Box<Integer>> cmp = new Comparator<>() {
      @Override
      public int compare(Box<Integer> b1, Box<Integer> b2) {
        return b1.value - b2.value;
      }
    };

    Comparator<Box<Integer>> cmp2 = Comparator.comparingInt(b -> b.value);

    boxes.sort(cmp2);
    System.out.println("---");
    boxes.forEach(b -> System.out.println(b));

  }
}
