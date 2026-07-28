package socialnetwork.chat.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document("conversations")
@Getter
@Setter
public class Conversation {

    @Id
    private String id;

    private List<String> participantIds;

    private Instant createdAt;

    private Instant lastMessageAt;
}
