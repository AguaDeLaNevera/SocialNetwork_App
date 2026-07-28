package socialnetwork.chat.dto;

import java.time.Instant;
import java.util.List;

public record ConversationResponse(
        String id,
        List<String> participantIds,
        Instant createdAt,
        Instant lastMessageAt
) {
}
