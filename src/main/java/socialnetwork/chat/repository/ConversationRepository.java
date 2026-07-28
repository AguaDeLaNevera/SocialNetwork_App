package socialnetwork.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import socialnetwork.chat.model.Conversation;

import java.util.List;

public interface ConversationRepository extends MongoRepository<Conversation, String> {

    List<Conversation> findByParticipantIdsContaining(String userId);

}
