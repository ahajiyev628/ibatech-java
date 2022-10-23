package TinderProject.DAO;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<A> {
    List<A> getAll();
    Optional<A> getById(String id);
    void put(A a);
    void delete(String id);
}
