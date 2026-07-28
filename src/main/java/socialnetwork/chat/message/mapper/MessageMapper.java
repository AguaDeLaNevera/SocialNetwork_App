package socialnetwork.chat.message.mapper;

import org.springframework.stereotype.Component;
import socialnetwork.chat.message.dto.MessageResponse;
import socialnetwork.chat.message.model.Message;

@Component
public class MessageMapper {

    public MessageResponse toMessageResponse(Message message) {

        return new MessageResponse(
                message.getId(),
                message.getSenderUsername(),
                message.getContent(),
                message.getSentAt(),
                message.isEdited(),
                message.isDeleted()
        );
    }
}