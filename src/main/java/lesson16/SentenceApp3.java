package lesson16;

import java.util.List;
import java.util.stream.Collectors;

public class SentenceApp3 {

  public static List<Sentence> mkCombinations(List<String> subjects, List<String> verbs, List<String> objects) {
    return subjects.stream().flatMap(s ->
        verbs.stream().flatMap(v ->
            objects.stream().map(o ->
                new Sentence(s, v, o)
            )
        )
    ).collect(Collectors.toList());
  }

  public static String represent(Sentence sentence) {
    return String.format("%s %s %s", sentence.subject, sentence.verb, sentence.object);
  }

  public static void main(String[] args) {
    List<String> subjects = List.of("Noel", "The cat", "The dog");
    List<String> verbs =    List.of("wrote", "chased", "slept on");
    List<String> objects =  List.of("the book","the ball","the bed");

    List<Sentence> sentences = mkCombinations(subjects, verbs, objects);

    sentences.forEach(s -> System.out.println(represent(s)));
  }
}
