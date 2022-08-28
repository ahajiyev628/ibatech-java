package lesson17.autoclosable;

import java.io.IOException;

public class AutoclosableExample {

  public static void main(String[] args) throws IOException {
    try(MySuperFunctionality x = new MySuperFunctionality()) {

    }
    // x.close will be called automatically
  }

}
