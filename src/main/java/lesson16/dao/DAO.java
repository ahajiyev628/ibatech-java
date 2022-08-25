package lesson16.dao;

public interface DAO<A> {
  void save(A p);
  A load(int id);
}
