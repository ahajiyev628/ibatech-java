package TinderProject.Objects;
import lombok.Data;

import java.sql.Date;

@Data
public class User {
    String id;
    String username;
    String password;
    String img;
    //Date create_date;

    public User(String id, String username, String password, String img) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.img = img;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}