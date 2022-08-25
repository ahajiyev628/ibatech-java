package lesson16;

import java.util.ArrayList;
import java.util.List;

public class SentenceApp1 {

  public static ArrayList<String> mkSentences(List<String> subjects, List<String> verbs, List<String> objects) {
    ArrayList<String> sentences = new ArrayList<>();
    for (String s: subjects) {
      for (String v: verbs) {
        for (String o: objects) {
          String sentence = String.format("%s %s %s", s, v, o);
          sentences.add(sentence);
        }
      }
    }
    return sentences;
  }

  public static void main(String[] args) {
    List<String> subjects = List.of("Noel", "The cat", "The dog");
    List<String> verbs =    List.of("wrote", "chased", "slept on");
    List<String> objects =  List.of("the book","the ball","the bed");

    ArrayList<String> sentences = mkSentences(subjects, verbs, objects);

    sentences.forEach(System.out::println);

  }
}
