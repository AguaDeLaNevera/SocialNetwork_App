package socialnetwork.chat.conversation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import socialnetwork.chat.conversation.model.Conversation;

import java.util.List;

public interface ConversationRepository extends MongoRepository<Conversation, String> {

    List<Conversation> findByParticipantIdsContaining(String userId);

}
