package socialnetwork.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import socialnetwork.notification.dto.NotificationResponse;
import socialnetwork.notification.mapper.NotificationMapper;
import socialnetwork.notification.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;
    private final NotificationMapper notificationMapper;

    public NotificationController(NotificationService notificationService,
                                  NotificationMapper notificationMapper) {
        this.notificationService = notificationService;
        this.notificationMapper = notificationMapper;
    }

    @GetMapping("/{receiverId}")
    public List<NotificationResponse> getNotifications(
            @PathVariable String receiverId) {

        return notificationService.getNotifications(receiverId)
                .stream()
                .map(notificationMapper::toNotificationResponse)
                .toList();
    }
}
