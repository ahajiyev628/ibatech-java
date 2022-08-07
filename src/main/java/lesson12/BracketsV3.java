package lesson12;

import java.util.Stack;

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
public class BracketsV3 {

  private static String opens  = "[(<{";
  private static String closes = "])>}";

  public boolean bracketCorresponds(char close, char open) {
    //              O(N)                   O(N)
    return opens.indexOf(open) == closes.indexOf(close);
  }

  public boolean isValid(String line) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i); // f
      // opens.contains(open)
      if (opens.indexOf(c) != -1) // closes.contains(close)
        stack.push(c);
      else if (closes.indexOf(c) != -1) {
        if (stack.isEmpty()) return false;
        char saved = stack.pop(); // can produce NPX
        if (!bracketCorresponds(c, saved)) return false;
      }
    }
    return stack.isEmpty();
  }

}
