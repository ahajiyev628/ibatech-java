package tinderProject.Objects;

import lombok.Data;

import java.util.Date;

@Data
public class Message {
    String sender_id;
    String sender;
    String receiver;
    String message_body;
    Date message_date;

    public Message(String sender_id, String sender, String receiver, String message_body, Date message_date) {
        this.sender_id = sender_id;
        this.sender = sender;
        this.receiver = receiver;
        this.message_body = message_body;
        this.message_date = message_date;
    }
}
