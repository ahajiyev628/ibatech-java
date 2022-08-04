package lesson11;

import java.util.*;

public class CharacterPositions {

  /**
   * "Hello, my dear friend, please keep learning, I'll guarantee you'll reach the moment you understand everything"
   *
   * e:16:<2,12,19,26,29,32,33,37,58,59,69,76,81,92,100,102>
   * l:8:<3,4,25,36,48,49,65,66>
   * n:8:<20,40,42,56,82,90,97,108>
   * r:7:<14,17,39,54,68,93,103>
   * a:7:<13,27,38,53,55,70,96>
   * t:5:<57,74,83,95,105>
   * i:4:<18,41,46,107>
   * h:4:<1,72,75,106>
   * u:4:<52,63,87,89>
   * d:4:<11,21,91,98>
   * y:4:<9,61,85,104>
   * o:4:<5,62,79,86>
   * g:3:<43,51,109>
   * m:3:<8,78,80>
   * s:2:<28,94>
   * p:2:<24,34>
   * k:1:<31>
   * f:1:<16>
   * c:1:<71>
   * v:1:<101>
   */

  // PLEASE STOP USING string.replace(...) / .replaceAll(...)
  public Map<Character, List<Integer>> doCount(String origin) {
    HashMap<Character, List<Integer>> counter = new HashMap<>();
    for (int i = 0; i < origin.length(); i++) {
      Character c = Character.toLowerCase(origin.charAt(i));
      if (Character.isLetter(c)) {
        List<Integer> positions = counter.getOrDefault(c, new ArrayList<>());
        positions.add(i + 1); // I'm human, not a computer :)
        counter.put(c, positions);
      }
    }
    return counter;
  }

  public static List<Pair<Character, List<Integer>>> mapToList(Map<Character, List<Integer>> data) {
    List<Pair<Character, List<Integer>>> list = new ArrayList<>();
    data.forEach((ch, poss) -> {
      Pair<Character, List<Integer>> pair = Pair.of(ch, poss);
      list.add(pair);
    });
    return list;
  }

  public static void main(String[] args) {
    CharacterPositions app = new CharacterPositions();
    String line = "Hello, my dear friend, please keep learning, I'll guarantee you'll reach the moment you understand everything";
    Map<Character, List<Integer>> outcome = app.doCount(line);
//    outcome.forEach((ch, list) -> System.out.printf("%s:%d:%s\n", ch, list.size(), list));
    List<Pair<Character, List<Integer>>> list = mapToList(outcome);
    list.forEach(pair -> System.out.printf("%s:%d:%s\n", pair.a, pair.b.size(), pair.b));

    Comparator<Pair<Character, List<Integer>>> cmp1 = new Comparator<>() {
      @Override
      public int compare(Pair<Character, List<Integer>> o1, Pair<Character, List<Integer>> o2) {
        return o2.b.size() - o1.b.size();
      }
    };

    Comparator<Pair<Character, List<Integer>>> cmp2 = Comparator.comparingInt(p -> p.b.size());
    Comparator<List<Integer>> listComparator = Comparator.comparingInt(l -> l.size());

    list.sort(cmp2);
    list.forEach(pair -> System.out.printf("%s:%d:%s\n", pair.a, pair.b.size(), pair.b));
  }


}
