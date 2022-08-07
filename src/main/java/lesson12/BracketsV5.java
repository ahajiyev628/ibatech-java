package lesson12;

import java.util.*;

/**
 * EASY != SIMPLE
 *
 * {
 *   {
 *     <<>><>
 *     {}{}(
 *     {
 *       ()
 *     }
 *     )
 *   }
 *   [][()]
 *   ()
 * }
 *
 * 1. {}
 * 2. []
 * 3. ()
 * 4. <>
 *
 *
 * }
 */
public class BracketsV5 {

  private static Map<Character, Character> pairs = Map.of(
      '(', ')',
      '{', '}',
      '[', ']',
      '<', '>'
  );
  private static Set<Character> close = new HashSet<>(pairs.values());

  public boolean bracketCorresponds(char close, char open) {
    return pairs.containsKey(open) // O(1)
        && pairs.get(open) == close; // O(1)
  }

  public boolean isValid(String line) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      if (pairs.containsKey(c)) // O(1)
        stack.push(c);
      else if (close.contains(c)) { // O(1)
        if (stack.isEmpty()) return false;
        char saved = stack.pop(); // can produce NPX
        if (!bracketCorresponds(c, saved)) return false;
      }
    }
    return stack.isEmpty();
  }

}
