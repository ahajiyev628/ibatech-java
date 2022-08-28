package lesson16.dao;

import java.io.File;

public class DaoPersonFile extends DaoFile<Person> {
  public DaoPersonFile(File file) {
    super(file);
  }
}
