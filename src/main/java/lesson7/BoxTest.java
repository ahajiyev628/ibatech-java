package lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoxTest {

  @Test
  public void fit() {
    Box box1 = new Box(1, 2, 3);
    Box box2 = new Box(2, 3, 6);
    boolean result = box1.compare(box2);
//    assertTrue(result);
    assertEquals(true, result); // fits
  }

  @Test
  public void doesntfit() {
    Box box1 = new Box(1, 2, 3);
    Box box2 = new Box(1,1,10);
    boolean result = box1.compare(box2); // doesn't fit
    assertFalse(result);
  }
}
