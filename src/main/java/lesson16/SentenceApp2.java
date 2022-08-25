package lesson16;

import java.util.ArrayList;
import java.util.List;

public class SentenceApp2 {

  public static ArrayList<Sentence> mkCombinations(List<String> subjects, List<String> verbs, List<String> objects) {
    ArrayList<Sentence> sentences = new ArrayList<>();
    for (String s: subjects) {
      for (String v: verbs) {
        for (String o: objects) {
          sentences.add(new Sentence(s, v, o));
        }
      }
    }
    return sentences;
  }

  public static String represent(Sentence sentence) {
    return String.format("%s %s %s", sentence.subject, sentence.verb, sentence.object);
  }

  public static void main(String[] args) {
    List<String> subjects = List.of("Noel", "The cat", "The dog");
    List<String> verbs =    List.of("wrote", "chased", "slept on");
    List<String> objects =  List.of("the book","the ball","the bed");

    ArrayList<Sentence> sentences = mkCombinations(subjects, verbs, objects);

    sentences.forEach(s -> System.out.println(represent(s)));
  }
}
