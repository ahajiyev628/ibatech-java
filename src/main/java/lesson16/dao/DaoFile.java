package lesson16.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DaoFile<A extends Identifiable> implements DAO<A> {

  private final File file;

  public DaoFile(File file) {
    this.file = file;
  }

  private List<A> loadAll() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
      return (List<A>) ois.readObject();
    } catch (Exception x) {
      return new ArrayList<>();
    }
  }

  private void saveAll(List<A> data) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
      oos.writeObject(data);
    } catch (Exception x) {
      System.out.println("There is an error during save...");
    }
  }

  @Override
  public void save(A p) {
    List<A> all = loadAll();
    all.add(p);
    saveAll(all);
  }

  @Override
  public Optional<A> load(int id) {
    List<A> all = loadAll();
    return all.stream().filter(p -> p.id() == id).findFirst();
  }

}
