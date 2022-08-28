package lesson16.dao;

import java.io.File;
import java.util.Optional;

public class App {

  public static <A extends Identifiable> void soSomething(DAO<A> dao) {
    /// ....
  }

  public static void main(String[] args) {
    Person p = new Person("Jim", 22);
    Pizza pz = new Pizza(3, 60);
    Student s = new Student(1, "Jim", "BE5");

    DAO<Person> daoPersonInmemory = new DaoPersonInMemory();
    daoPersonInmemory.save(p);
    Optional<Person> p1 = daoPersonInmemory.load(123);

    DAO<Person> daoPersonFile = new DaoPersonFile(new File("persons.bin"));
    daoPersonFile.save(p);
    Optional<Person> p2 = daoPersonFile.load(123);

    soSomething(daoPersonInmemory);
    soSomething(daoPersonFile);

    DaoPizzaInMemory daoPizzaInMemory1 = new DaoPizzaInMemory();
    DaoPizza         daoPizzaInMemory2 = new DaoPizzaInMemory();
    DAO<Pizza>       daoPizzaInMemory3 = new DaoPizzaInMemory();

//
//    ???.save(pz);
//    ???.deletePizza(123);
//    Pizza pz0 = ???.read(123);

    // Student, ...
    // HashMap, SQL, noSQL, TextFile, BinaryFile, send them via net, ...
  }
}
