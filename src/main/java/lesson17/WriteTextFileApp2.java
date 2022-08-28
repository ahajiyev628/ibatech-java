package lesson17;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFileApp2 {

  public static void main(String[] args) throws IOException {
    String fileName = "students.txt";
    File file = new File(fileName);
    // Java 1.7
    try (BufferedWriter w = new BufferedWriter(new FileWriter(file, true))) {
      w.write("Jim");
      w.write("\n");
      w.write("Alex");
      w.write("\n");
      w.write("Sergio");
    }
  }

}
