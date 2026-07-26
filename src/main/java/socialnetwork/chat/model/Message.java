package socialnetwork.chat.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("messages")
@Getter
@Setter
public class Message {

    @Id
    private String messageId;
    private String conversationId;
    private String senderId;
    private String senderUsername;
    private String senderDisplayName;
    private String senderAvatarUrl;
    private String content;
    private Instant sentAt;
}
