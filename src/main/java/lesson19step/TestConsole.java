package lesson19step;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TestConsole implements Console {

  private final Iterator<String> it;
  final ArrayList<String> output = new ArrayList<>();

  /** primary constructor, must be called ! */
  public TestConsole(Iterator<String> it) {
    this.it = it;
  }

  /** secondary constructor #1, accepts any kind of  */
  public TestConsole(Iterable<String> iterable) {
    this(iterable.iterator());
  }

  /** helper method */
  private static List<String> fileToList(File file) {
    try(BufferedReader r = new BufferedReader(new FileReader(file))) {
      return r.lines().collect(Collectors.toList());
    } catch (Exception x) {
      return new ArrayList<>();
    }
  }

  /** secondary constructor #2 */
  public TestConsole(File file) {
    this(fileToList(file));
  }

  @Override
  public String nextLine() {
    return it.next();
  }

  @Override
  public void printLine(String line) {
    output.add(line);
  }
}
