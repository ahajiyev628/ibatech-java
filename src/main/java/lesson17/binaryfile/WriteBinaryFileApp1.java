package lesson17.binaryfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class WriteBinaryFileApp1 {

  public static void main(String[] args) throws IOException {
    String fileName = "data.bin";
    File file = new File(fileName);
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
      oos.writeInt(33);
      oos.writeUTF("whatever");
      oos.writeObject(new Pizza(60));
      oos.writeObject(new Person("Jim", 33));
      oos.writeObject(new Person("Alex", 44));
      List<Person> data = Arrays.asList(
          new Person("Sergio", 22),
          new Person("Name", 23)
      );
      oos.writeObject(data);
    }
  }

}
