package socialnetwork.notification.mapper;

import org.springframework.stereotype.Component;
import socialnetwork.notification.dto.NotificationResponse;
import socialnetwork.notification.model.Notification;

@Component
public class NotificationMapper {

    public NotificationResponse toNotificationResponse(Notification notification) {

        return new NotificationResponse(
                notification.getId(),
                notification.getSenderUsername(),
                notification.getSenderAvatarUrl(),
                notification.getType(),
                notification.getReferenceId(),
                notification.isRead(),
                notification.getCreatedAt()
        );
    }
}
