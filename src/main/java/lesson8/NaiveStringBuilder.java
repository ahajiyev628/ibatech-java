package lesson8;

public class NaiveStringBuilder {

  private String[] data = new String[100];
  private int pointer;

  public void append(String s) {
    data[pointer++] = s;
  }

  @Override
  public String toString() {
    // know the total length
    int len = 0;
    for (int i = 0; i < data.length; i++) {
      len += data[i].length();
    }
    // allocate the memory
    char[] composed = new char[len];
    // copy
    // create new string from array;
    String newString = new String(composed);
    // return
    return newString;
  }
}
