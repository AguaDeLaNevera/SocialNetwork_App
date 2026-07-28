package socialnetwork.notification.service;

import org.springframework.stereotype.Service;
import socialnetwork.notification.model.Notification;
import socialnetwork.notification.model.NotificationType;
import socialnetwork.notification.repository.NotificationRepository;
import socialnetwork.user.model.User;

import java.time.Instant;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification createNotification(User sender,
                                           User receiver,
                                           NotificationType type,
                                           String referenceId) {

        Notification notification = new Notification();

        notification.setReceiverId(receiver.getId());

        notification.setSenderId(sender.getId());
        notification.setSenderUsername(sender.getUsername());
        notification.setSenderAvatarUrl(sender.getAvatarUrl());

        notification.setType(type);

        notification.setReferenceId(referenceId);

        notification.setRead(false);

        notification.setCreatedAt(Instant.now());

        return notificationRepository.save(notification);
    }

    public List<Notification> getNotifications(String receiverId) {
        return notificationRepository
                .findByReceiverIdOrderByCreatedAtDesc(receiverId);
    }
}