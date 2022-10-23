package TinderProject.Objects;

import lombok.Data;

import java.util.Date;
@Data
public class Likes {
    String user_id;
    String liked_by;
    String liked_to;
    String like_dislike;
    Date like_dislike_date;

    public Likes(String user_id, String liked_by, String liked_to, String like_dislike, Date like_dislike_date) {
        this.user_id = user_id;
        this.liked_by = liked_by;
        this.liked_to = liked_to;
        this.like_dislike = like_dislike;
        this.like_dislike_date = like_dislike_date;
    }
}

