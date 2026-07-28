package socialnetwork.chat.dto;

public record CreateMessageRequest(
        String username,
        String conversationId,
        String content
) {
}