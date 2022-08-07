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
public class BracketsV4 {

  private static Map<Character, Character> pairs = new HashMap<>();
  static {
    pairs.put('(', ')');
    pairs.put('{', '}');
    pairs.put('[', ']');
    pairs.put('<', '>');
  }

  public boolean bracketCorresponds(char close, char open) {
    return pairs.containsKey(open)
        && pairs.get(open) == close;
  }

  public boolean isValid(String line) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      if (pairs.containsKey(c)) // O(1)
        stack.push(c);
      else if (pairs.containsValue(c)) { // O(N)
        if (stack.isEmpty()) return false;
        char saved = stack.pop(); // can produce NPX
        if (!bracketCorresponds(c, saved)) return false;
      }
    }
    return stack.isEmpty();
  }

}
