package TinderProject.Objects;
import lombok.Data;

import java.sql.Date;

@Data
public class User {
    String id;
    String username;
    String password;
    //Date create_date;
    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}