package socialnetwork.chat.message.controller;

import org.springframework.web.bind.annotation.*;
import socialnetwork.chat.message.dto.CreateMessageRequest;
import socialnetwork.chat.message.dto.MessageResponse;
import socialnetwork.chat.message.mapper.MessageMapper;
import socialnetwork.chat.message.model.Message;
import socialnetwork.chat.message.service.MessageService;
import socialnetwork.user.model.User;
import socialnetwork.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;
    private final UserService userService;
    private final MessageMapper messageMapper;

    public MessageController(MessageService messageService,
                             UserService userService,
                             MessageMapper messageMapper) {
        this.messageService = messageService;
        this.userService = userService;
        this.messageMapper = messageMapper;
    }

    @PostMapping
    public MessageResponse createMessage(
            @RequestBody CreateMessageRequest request) {

        User user = userService.getUserByUsername(request.username());

        Message message = messageService.createMessage(user, request);

        return messageMapper.toMessageResponse(message);
    }

    @GetMapping("/conversation/{conversationId}")
    public List<MessageResponse> getMessages(
            @PathVariable String conversationId) {

        return messageService.getMessages(conversationId)
                .stream()
                .map(messageMapper::toMessageResponse)
                .toList();
    }
}