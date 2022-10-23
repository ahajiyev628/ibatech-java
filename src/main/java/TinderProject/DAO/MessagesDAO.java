package TinderProject.DAO;

import TinderProject.Objects.Message;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MessagesDAO implements DAO<Message> {
    private final Connection conn;

    public MessagesDAO(Connection conn) {
        this.conn = conn;
    }
    @SneakyThrows
    @Override
    public List<Message> getAll() {
        PreparedStatement stmt = conn.prepareStatement("select * from abb_tech.messages");
        ResultSet resultSet = stmt.executeQuery();
        ArrayList<Message> messages = new ArrayList<>();
        while (resultSet.next()) {
            Message m = new Message(
                    resultSet.getString("sender_id"),
                    resultSet.getString("sender"),
                    resultSet.getString("receiver"),
                    resultSet.getString("message_body"),
                    resultSet.getDate("message_date")
            );
            messages.add(m);
        }
        return messages;
    }

    @SneakyThrows
    @Override
    public Optional<Message> getById(String id) {
        PreparedStatement stmt = conn.prepareStatement("select * from abb_tech.messages where id = ?");
        stmt.setString(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new Message(
                    resultSet.getString("sender_id"),
                    resultSet.getString("sender"),
                    resultSet.getString("receiver"),
                    resultSet.getString("message_body"),
                    resultSet.getDate("message_date")));
        }
        else return Optional.empty();
    }

    @SneakyThrows
    @Override
    public void put(Message msg) {
        PreparedStatement st = conn.prepareStatement("insert into abb_tech.messages (sender_id, sender, receiver, message_body, message_date) values (?,?,?,?,?)");
        st.setString(1, msg.getSender_id());
        st.setString(2, msg.getSender());
        st.setString(3, msg.getReceiver());
        st.setString(4, msg.getMessage_body());
        st.setDate(5, (Date) msg.getMessage_date());
        st.execute();
    }
    @SneakyThrows
    @Override
    public void delete(String id) {
        PreparedStatement st = conn.prepareStatement("delete from abb_tech.messages where id = ?");
        st.setString(1, id);
        st.execute();
    }
}