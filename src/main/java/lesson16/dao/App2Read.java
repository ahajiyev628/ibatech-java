package lesson16.dao;

import java.io.File;

public class App2Read {

  public static void main(String[] args) {
    DAO<Person> dao =
//        new DaoPersonInMemory();
        new DaoPersonFile(new File("persons.bin"));

    // read
    System.out.println(dao.load(1));  // Optional.empty
    System.out.println(dao.load(33)); // Optional[Person{name='Alex', id=33}]
  }
}
