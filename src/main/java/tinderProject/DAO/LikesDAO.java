package tinderProject.DAO;

import lombok.SneakyThrows;
import tinderProject.Objects.Likes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LikesDAO implements dao<Likes> {
    private final Connection conn;
    public LikesDAO(Connection conn) {
        this.conn = conn;
    }

    @SneakyThrows
    @Override
    public List<Likes> getAll() {
        PreparedStatement stmt = conn.prepareStatement("select * from likes");
        ResultSet resultSet = stmt.executeQuery();
        ArrayList<Likes> likes = new ArrayList<>();
        while (resultSet.next()) {
            Likes l = new Likes(
                    resultSet.getString("user_id"),
                    resultSet.getString("liked_by"),
                    resultSet.getString("liked_to"),
                    resultSet.getString("imgurl"),
                    resultSet.getString("like_dislike"),
                    resultSet.getDate("like_dislike_date")
            );
            likes.add(l);
        }
        return likes;
    }
    @SneakyThrows
    @Override
    public int getCount() {
        PreparedStatement stmt = conn.prepareStatement("select count(*) cnt from likes");
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
    public Optional<Likes> getById(String id) {
        PreparedStatement stmt = conn.prepareStatement("select * from likes where id = ?");
        stmt.setString(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if(resultSet.next()) {
            return Optional.of(new Likes(
                    resultSet.getString("user_id"),
                    resultSet.getString("liked_by"),
                    resultSet.getString("liked_to"),
                    resultSet.getString("imgurl"),
                    resultSet.getString("like_dislike"),
                    resultSet.getDate("like_dislike_date")));
        }
        else return Optional.empty();
    }
    @SneakyThrows
    @Override
    public void put(Likes like) {
        PreparedStatement st = conn.prepareStatement("insert into likes (user_id, liked_by, liked_to, imgurl,  like_dislike, like_dislike_date) values (?,?,?,?,?,?)");
        st.setString(1, like.getUser_id());
        st.setString(2, like.getLiked_by());
        st.setString(3, like.getLiked_to());
        st.setString(4, like.getImgurl());
        st.setString(5, like.getLike_dislike());
        st.setDate(6, (Date) like.getLike_dislike_date());
        st.execute();
    }
    @SneakyThrows
    @Override
    public void delete(String id) {
        PreparedStatement st = conn.prepareStatement("delete from likes where id = ?");
        st.setString(1, id);
        st.execute();
    }
}