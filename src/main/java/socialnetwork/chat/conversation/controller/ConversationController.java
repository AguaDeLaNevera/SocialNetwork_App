package socialnetwork.chat.conversation.controller;

import org.springframework.web.bind.annotation.*;
import socialnetwork.chat.conversation.dto.ConversationResponse;
import socialnetwork.chat.conversation.dto.CreateConversationRequest;
import socialnetwork.chat.conversation.mapper.ConversationMapper;
import socialnetwork.chat.conversation.model.Conversation;
import socialnetwork.chat.conversation.service.ConversationService;
import socialnetwork.user.model.User;
import socialnetwork.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/conversations")
public class ConversationController {

    private final ConversationService conversationService;
    private final UserService userService;
    private final ConversationMapper conversationMapper;

    public ConversationController(ConversationService conversationService,
                                  UserService userService,
                                  ConversationMapper conversationMapper) {
        this.conversationService = conversationService;
        this.userService = userService;
        this.conversationMapper = conversationMapper;
    }

    @PostMapping
    public ConversationResponse createConversation(
            @RequestBody CreateConversationRequest request) {

        User creator = userService.getUserByUsername(request.creatorUsername());
        User recipient = userService.getUserByUsername(request.recipientUsername());

        Conversation conversation =
                conversationService.createConversation(creator, recipient);

        return conversationMapper.toConversationResponse(conversation);
    }

    @GetMapping("/user/{userId}")
    public List<ConversationResponse> getConversations(
            @PathVariable String userId) {

        return conversationService.getConversations(userId)
                .stream()
                .map(conversationMapper::toConversationResponse)
                .toList();
    }
}