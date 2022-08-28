package lesson16.dao;

import java.io.File;

public class App3pizza {

  public static void main(String[] args) {
    DAO<Pizza> dao =
        new DaoPizzaFile(new File("pizza.bin"));

    // write
    dao.save(new Pizza(1, 30));
    dao.save(new Pizza(2, 45));
    dao.save(new Pizza(3, 60));

    // read
    System.out.println(dao.load(5));
    System.out.println(dao.load(3));
  }
}
