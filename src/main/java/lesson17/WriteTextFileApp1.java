package lesson17;

import java.io.*;

public class WriteTextFileApp1 {

  public static void main(String[] args) throws IOException {
    String fileName = "students.txt";
    File file = new File(fileName);
    BufferedWriter w = new BufferedWriter(new FileWriter(file, true));
    w.write("Jim");
    w.write("\n");
    w.write("Alex");
    w.write("\n");
    w.write("Sergio");
    w.flush(); // move data mem -> disk
    w.close(); // closing resource
  }

}
