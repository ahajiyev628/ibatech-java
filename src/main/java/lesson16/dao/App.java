package lesson16.dao;

import java.io.File;

public class App {

  public static <A> void soSomething(DAO<A> dao) {
    /// ....
  }

  public static void main(String[] args) {
    Person p = new Person();
    Pizza pz = new Pizza();
    Student s = new Student();

    DAO<Person> daoPersonInmemory = new DaoPersonInMemory();
    daoPersonInmemory.save(p);
    Person p1 = daoPersonInmemory.load(123);

    DAO<Person> daoPersonFile = new DaoPersonFile(new File("persons.bin"));
    daoPersonFile.save(p);
    Person p2 = daoPersonFile.load(123);

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
