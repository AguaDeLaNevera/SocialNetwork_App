package socialnetwork.chat.conversation.dto;

public record CreateConversationRequest(
        String creatorUsername,
        String recipientUsername
) {
}