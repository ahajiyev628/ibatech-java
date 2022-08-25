package lesson16.dao;

import java.io.File;

public class DaoPersonFile implements DaoPerson {

  private final File file;

  public DaoPersonFile(File file) {
    this.file = file;
  }

  @Override
  public void save(Person p) {
    throw new IllegalArgumentException("not implemented");
  }

  @Override
  public Person load(int id) {
    throw new IllegalArgumentException("not implemented");
  }

}
