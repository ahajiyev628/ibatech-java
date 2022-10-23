package TinderProject.DAO;

import TinderProject.Database.ConnectionDB;
import TinderProject.Objects.User;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDAO implements DAO<User> {
    private final Connection conn;

    public UsersDAO(Connection conn) {
        this.conn = conn;
    }
    @SneakyThrows
    @Override
    public List<User> getAll() {
        PreparedStatement stmt = conn.prepareStatement("select * from abb_tech.users");
        ResultSet resultSet = stmt.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User s = new User(
                    resultSet.getString("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password")
            );
            users.add(s);
        }
        return users;
    }
    
    @SneakyThrows
    @Override
    public Optional<User> getById(String id) {
        PreparedStatement stmt = conn.prepareStatement("select * from abb_tech.users where id = ?");
        stmt.setString(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()) {
                return Optional.of(new User(resultSet.getString("id"),
                                            resultSet.getString("username"),
                                            resultSet.getString("password")
                ));
        }
        else return Optional.empty();
    }

    @SneakyThrows
    @Override
    public void put(User user) {
        PreparedStatement st = conn.prepareStatement("insert into abb_tech.users (id, username, password) values (?,?,?);commit;");
        st.setString(1, user.getId());
        st.setString(2, user.getUsername());
        st.setString(3, user.getPassword());
        st.execute();
    }
    @SneakyThrows
    @Override
    public void delete(String id) {
        PreparedStatement st = conn.prepareStatement("delete from abb_tech.users where id = ?");
        st.setString(1, id);
        st.execute();
    }
}