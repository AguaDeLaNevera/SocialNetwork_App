package socialnetwork.chat.conversation.dto;

import java.time.Instant;
import java.util.List;

public record ConversationResponse(
        String id,
        List<String> participantIds,
        Instant createdAt,
        String lastMessage,
        Instant lastMessageAt
) {
}
