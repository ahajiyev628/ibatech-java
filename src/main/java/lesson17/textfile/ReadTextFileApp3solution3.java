package lesson17.textfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadTextFileApp3solution3 {

  // we can NOT distinguish whether:
  //   - file not found
  //   - file is empty
  // public static List<String> readFile(String fileName) {}

  public static Optional<List<String>> readFile(String fileName) {
    File file = new File(fileName);
    try (BufferedReader r = new BufferedReader(new FileReader(file))){
      Stream<String> lines = r.lines();
      // Exception FileNotFoundException: students1.txt (No such file or directory)
      return Optional.of(lines.collect(Collectors.toList()));
    } catch (FileNotFoundException x) {
      return Optional.empty();
    } catch (IOException x) { // something went wrong AFTER successfully opening
      return Optional.empty();
    }
  }

  public static void main(String[] args) throws IOException {
    String fileName = "students.txt";
    Optional<List<String>> maybeContents = readFile(fileName);
    // approach ONE. process two cases differently
    maybeContents.ifPresentOrElse(
        list -> list.forEach(line -> System.out.printf("line read: %s\n", line)),
        () -> System.out.printf("File `%s` not found. terminating...", fileName)
    );
    // approach TWO. it's Okay to have an empty list as a result
    List<String> contents = maybeContents.orElse(new ArrayList<>());
  }

}
