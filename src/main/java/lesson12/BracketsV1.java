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
public class BracketsV1 {

  public boolean isValid(String line) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      switch (c) {
        case '{':
          stack.push(c);
          break;
        case '}':
          if (stack.isEmpty()) return false;
          stack.pop(); // can produce NPX
          break;
        default:
      }
    }
    return stack.isEmpty();
  }

}
