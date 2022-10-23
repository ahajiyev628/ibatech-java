package TinderProject.DAO;

import TinderProject.Database.ConnectionDB;
import TinderProject.Objects.User;
import lesson27web.HistoryItem;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class UsersDAO implements DAO<User> {
    private final Connection conn;

    public UsersDAO(Connection conn) {
        this.conn = conn;
    }
    @SneakyThrows
    @Override
    public ArrayList<User> getAll() {
        PreparedStatement stmt = conn.prepareStatement("select * from abb_tech.users");
        ResultSet resultSet = stmt.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        HashMap<Integer, User> data = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            User s = new User(
                    resultSet.getString("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("img")
            );
            users.add(s);
            data.put(i, s);
            i++;
        }
        return users;
    }
    public HashMap<String, User> getAllData() throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("select * from abb_tech.users");
        ResultSet resultSet = stmt.executeQuery();
        HashMap<String, User> data = new HashMap<>();
        //int i = 0;
        while (resultSet.next()) {
            User s = new User(
                    resultSet.getString("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("img")
            );
            data.put("data", s);
          //  i++;
        }
        return data;
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
                                            resultSet.getString("password"),
                                            resultSet.getString("img")
                ));
        }
        else return Optional.empty();
    }

    @SneakyThrows
    @Override
    public void put(User user) {
        PreparedStatement st = conn.prepareStatement("insert into abb_tech.users (id, username, password, img) values (?,?,?,?);commit;");
        st.setString(1, user.getId());
        st.setString(2, user.getUsername());
        st.setString(3, user.getPassword());
        st.setString(4, user.getImg());
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