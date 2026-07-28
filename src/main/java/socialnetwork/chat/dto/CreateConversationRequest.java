package socialnetwork.chat.dto;

public record CreateConversationRequest(
        String creatorUsername,
        String recipientUsername
) {
}