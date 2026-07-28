package socialnetwork.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import socialnetwork.chat.model.Message;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findByConversationIdOrderByCreatedAtAsc(
            String conversationId);

}