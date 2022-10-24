package tinderProject.Objects;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    String sender_id;
    String receiver;
    String message_body;
    Date message_date;

    public Message(String sender_id, String receiver, String message_body) {
        this.sender_id = sender_id;
        this.receiver = receiver;
        this.message_body = message_body;
    }
}
