package socialnetwork.chat.conversation.mapper;

import org.springframework.stereotype.Component;
import socialnetwork.chat.conversation.dto.ConversationResponse;
import socialnetwork.chat.conversation.model.Conversation;

@Component
public class ConversationMapper {

    public ConversationResponse toConversationResponse(Conversation conversation) {

        return new ConversationResponse(
                conversation.getId(),
                conversation.getParticipantIds(),
                conversation.getCreatedAt(),
                conversation.getLastMessage(),
                conversation.getLastMessageAt()
        );
    }
}
