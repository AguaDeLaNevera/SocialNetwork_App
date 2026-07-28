package socialnetwork.chat.dto;

import java.time.Instant;

public record MessageResponse(
        String id,
        String senderUsername,
        String content,
        Instant createdAt,
        Boolean isEdited,
        Boolean isDeleted
) {
}