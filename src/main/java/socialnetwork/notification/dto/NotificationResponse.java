package socialnetwork.notification.dto;

import socialnetwork.notification.model.NotificationType;

import java.time.Instant;

public record NotificationResponse(
        String id,
        String senderUsername,
        String senderAvatarUrl,
        NotificationType type,
        String  referenceId,
        boolean read,
        Instant createdAt
) {
}
