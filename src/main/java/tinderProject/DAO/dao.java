package tinderProject.DAO;

import java.util.List;
import java.util.Optional;

public interface dao<A> {
    List<A> getAll();
    Optional<A> getById(String id);
    void put(A a);
    void delete(String id);
    int getCount();
}
