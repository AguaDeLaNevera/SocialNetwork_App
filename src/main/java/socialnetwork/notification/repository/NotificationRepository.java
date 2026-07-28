package socialnetwork.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import socialnetwork.notification.model.Notification;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findByReceiverIdOrderByCreatedAtDesc(String receiverId);

    List<Notification> findByReceiverIdAndReadFalse(String receiverId);
}