package socialnetwork.chat.message.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import socialnetwork.chat.message.model.Message;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findByConversationIdOrderByCreatedAtAsc(
            String conversationId);

}