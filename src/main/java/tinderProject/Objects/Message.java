package tinderProject.Objects;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    String sender_id;
    String receiver;
    String message;

    public Message(String sender_id, String receiver, String message) {
        this.sender_id = sender_id;
        this.receiver = receiver;
        this.message = message;
    }

    public Message() {

    }
}
