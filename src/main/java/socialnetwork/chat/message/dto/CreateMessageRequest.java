package socialnetwork.chat.message.dto;

public record CreateMessageRequest(
        String username,
        String conversationId,
        String content
) {
}