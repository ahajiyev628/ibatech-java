package tinderProject.DAO;

import lombok.SneakyThrows;
import tinderProject.Objects.Message;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class MessagesDAO implements dao<Message> {
    private final Connection conn;

    public MessagesDAO(Connection conn) {
        this.conn = conn;
    }
    @SneakyThrows
    @Override
    public ArrayList<Message> getAll() {
        PreparedStatement stmt = conn.prepareStatement("select * from abb_tech.messages");
        ResultSet resultSet = stmt.executeQuery();
        ArrayList<Message> messages = new ArrayList<>();
        while (resultSet.next()) {
            Message m = new Message(
                    resultSet.getString("sender_id"),
                    resultSet.getString("receiver"),
                    resultSet.getString("message")
            );
            messages.add(m);
        }
        return messages;
    }
    @SneakyThrows
    @Override
    public int getCount() {
        PreparedStatement stmt = conn.prepareStatement("select count(*) cnt from messages");
        ResultSet resultSet = stmt.executeQuery();
        int count=0;
        if (resultSet.next()) {
            count= resultSet.getInt(1);
            return count;
        }
        return 0;
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
                    resultSet.getString("receiver"),
                    resultSet.getString("message")));
        }
        else return Optional.empty();
    }
    @SneakyThrows
    @Override
    public void put(Message msg) {
        PreparedStatement st = conn.prepareStatement("insert into abb_tech.messages (sender_id, receiver, message) values (?,?,?);commit;");
        st.setString(1, msg.getSender_id());
        st.setString(2, msg.getReceiver());
        st.setString(3, msg.getMessage());
        st.execute();
    }
    @SneakyThrows
    @Override
    public void delete(String id) {
        PreparedStatement st = conn.prepareStatement("delete from abb_tech.messages where id = ?");
        st.setString(1, id);
        st.execute();
        conn.commit();
    }
}