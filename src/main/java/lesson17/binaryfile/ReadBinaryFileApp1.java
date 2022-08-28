package lesson17.binaryfile;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ReadBinaryFileApp1 {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    String fileName = "data.bin";
    File file = new File(fileName);
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
      int i = ois.readInt();
      System.out.printf("int: %d\n", i);
      String s = ois.readUTF();
      System.out.printf("int: %s\n", s);
      Pizza pz = (Pizza) ois.readObject();
      System.out.printf("pizza: %s\n", pz);
      Person p1 = (Person) ois.readObject();
      System.out.printf("person1: %s\n", p1);
      Person p2 = (Person) ois.readObject();
      System.out.printf("person2: %s\n", p2);
      List<Person> ps = (List<Person>) ois.readObject();
      System.out.printf("persons: %s\n", ps);
    }
  }

}
