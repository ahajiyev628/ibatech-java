package lesson17.textfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadTextFileApp3solution2 {

  public static void main(String[] args) throws IOException {
    String fileName = "students1.txt";
    File file = new File(fileName);
    List<String> content;
    try (BufferedReader r = new BufferedReader(new FileReader(file))){
      Stream<String> lines = r.lines();
      // Exception FileNotFoundException: students1.txt (No such file or directory)
      content = lines.collect(Collectors.toList());
      content.forEach(line -> System.out.printf("line read: %s\n", line));
    } catch (FileNotFoundException x) {
      System.out.printf("File `%s` not found. terminating...", fileName);
      System.exit(1);
    }

  }

}
