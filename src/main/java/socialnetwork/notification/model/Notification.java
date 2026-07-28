package socialnetwork.notification.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("notifications")
@Getter
@Setter
public class Notification {

    @Id
    private String id;

    private String receiverId;

    private String senderId;
    private String senderUsername;
    private String senderAvatarUrl;

    private NotificationType type;

    private String referenceId;

    private boolean read;

    private Instant createdAt;
}
