package socialnetwork.chat.message.service;

import org.springframework.stereotype.Service;
import socialnetwork.chat.message.dto.CreateMessageRequest;
import socialnetwork.chat.conversation.model.Conversation;
import socialnetwork.chat.message.model.Message;
import socialnetwork.chat.conversation.repository.ConversationRepository;
import socialnetwork.chat.message.repository.MessageRepository;
import socialnetwork.user.model.User;

import java.time.Instant;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;

    public MessageService(MessageRepository messageRepository,
                          ConversationRepository conversationRepository) {

        this.messageRepository = messageRepository;
        this.conversationRepository = conversationRepository;
    }

    public Message createMessage(User user,
                                 CreateMessageRequest request) {

        Message message = new Message();

        message.setConversationId(request.conversationId());

        message.setSenderId(user.getId());
        message.setSenderUsername(user.getUsername());

        message.setContent(request.content());

        message.setSentAt(Instant.now());

        message.setEdited(false);

        Conversation conversation =
                conversationRepository
                        .findById(request.conversationId())
                        .orElse(null);

        if (conversation != null) {

            conversation.setLastMessageAt(Instant.now());

            conversationRepository.save(conversation);
        }

        return messageRepository.save(message);
    }

    public List<Message> getMessages(String conversationId) {

        return messageRepository
                .findByConversationIdOrderByCreatedAtAsc(conversationId);
    }
}
