package lesson16.dao;

import java.io.File;

public class App2 {

  public static void main(String[] args) {
    DAO<Person> dao =
//        new DaoPersonInMemory();
        new DaoPersonFile(new File("persons.bin"));

    // write
    dao.save(new Person("Jim", 22));
    dao.save(new Person("Alex", 33));

    // read
    System.out.println(dao.load(1));  // Optional.empty
    System.out.println(dao.load(33)); // Optional[Person{name='Alex', id=33}]
  }
}
