package lesson16.dao;

import java.util.Optional;

// out type `A` must have `id` of type Integer
public interface DAO<A extends Identifiable> {
  void save(A p);
  Optional<A> load(int id);
}
