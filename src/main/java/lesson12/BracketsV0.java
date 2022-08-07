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
public class BracketsV0 {

  public boolean isValid(String line) {
    int depth = 0;
    for (int i = 0; i < line.length(); i++) {
      char c = line.charAt(i);
      switch (c) {
        case '{':
          depth++;
          break;
        case '}':
          if (depth == 0) return false;
          depth--;
          break;
        default:
      }
    }
    return depth == 0;
  }

}
