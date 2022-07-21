package lesson7;

import static lesson7.Light.Red;

enum Light {
  Red, Green, Blue
}

enum Dark {
  Red, Green, Blue
}

public class Colors {

  public static void main(String[] args) {
    Light red = Light.Red; // ??
    Dark red1 = Dark.Red;
    Light red2 = Red;
  }
}