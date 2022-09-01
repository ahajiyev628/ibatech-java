package lesson18;

import lesson11.Pair;
import lesson16.Sentence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MeaningfulSentence {

  // Noel: wrote, chased, slept on
  public static Pair<String, String[]> parseLine(String line) {
    String[] splitted = line.split(": ");
    String a = splitted[0];
    String b = splitted[1];
    String[] bs = b.split(", ");
    return new Pair<>(a, bs);
  }
  /**
   * Noel: wrote, chased, slept on
   * The cat: meowed at, chased, slept on
   * The dog: barked at, chased, slept on
   */
  public static Map<String, String[]> readFile(String fileName) {
    HashMap<String, String[]> data = new HashMap<>();
    try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
      br.lines()
          .map(line ->parseLine(line))
          .forEach(p -> data.put(p.a, p.b));
    } catch (IOException x) {
      throw new IllegalArgumentException(
          String.format("File %s read error", fileName));
    }
    return data;
  }

  public static String represent(Sentence sentence) {
    return String.format("%s %s %s", sentence.subject, sentence.verb, sentence.object);
  }

  public static void main(String[] args) {
    Map<String, String[]> subVer = readFile("src/main/java/lesson18/subj_verb_.txt");
    Map<String, String[]> verObj = readFile("src/main/java/lesson18/verb_obj_.txt");
    System.out.println(subVer);
    System.out.println(verObj);

    List<Sentence> collected =
        subVer.entrySet().stream().flatMap(sv ->
            Arrays.stream(sv.getValue()).flatMap(verb ->
                Arrays.stream(verObj.get(verb)).map(object ->
                    new Sentence(sv.getKey(), verb, object)
                )
            ))
        .collect(Collectors.toList());

    collected.forEach(s -> System.out.println(represent(s)));
  }

}
