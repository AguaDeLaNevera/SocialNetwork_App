package socialnetwork.chat.service;

import org.springframework.stereotype.Service;
import socialnetwork.chat.model.Conversation;
import socialnetwork.chat.repository.ConversationRepository;
import socialnetwork.user.model.User;

import java.time.Instant;
import java.util.List;

@Service
public class ConversationService {

    private final ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    public Conversation createConversation(User creator,
                                           User recipient) {

        Conversation conversation = new Conversation();

        conversation.setParticipantIds(
                List.of(
                        creator.getId(),
                        recipient.getId()
                )
        );

        conversation.setCreatedAt(Instant.now());

        conversation.setLastMessageAt(Instant.now());

        return conversationRepository.save(conversation);
    }

    public List<Conversation> getConversations(String userId) {

        return conversationRepository
                .findByParticipantIdsContaining(userId);
    }
}
