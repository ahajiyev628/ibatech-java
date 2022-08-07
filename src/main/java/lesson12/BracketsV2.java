package lesson12;

import java.util.Stack;

/**
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
public class BracketsV2 {

  public boolean bracketCorresponds(char close, char open) {
    String opens  = "[(<{";
    String closes = "])>}";
    return opens.indexOf(open) == closes.indexOf(close);
  }

  public boolean isValid(String line) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      switch (c) {
        case '{':
        case '<':
        case '[':
        case '(':
          stack.push(c);
          break;
        case '}':
        case '>':
        case ']':
        case ')':
          if (stack.isEmpty()) return false;
          char saved = stack.pop(); // can produce NPX
          if (!bracketCorresponds(c, saved)) return false;
          break;
        default:
      }
    }
    return stack.isEmpty();
  }

}
