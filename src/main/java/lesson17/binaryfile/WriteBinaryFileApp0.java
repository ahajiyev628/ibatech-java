package lesson17.binaryfile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// complicated and hard
public class WriteBinaryFileApp0 {

  public static void main(String[] args) throws IOException {
    String fileName = "data.bin";
    File file = new File(fileName);
    try (FileWriter w = new FileWriter(file, true)) {
      w.write("Hello");
      w.write("Jim");
      w.write("A\nB\n");
    }
    try (FileReader r = new FileReader(file)) {
    }
  }

}
