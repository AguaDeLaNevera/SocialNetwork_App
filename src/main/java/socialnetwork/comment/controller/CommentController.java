package socialnetwork.comment.controller;

import org.springframework.web.bind.annotation.*;
import socialnetwork.comment.dto.CommentResponse;
import socialnetwork.comment.dto.CreateCommentRequest;
import socialnetwork.comment.mapper.CommentMapper;
import socialnetwork.comment.model.Comment;
import socialnetwork.comment.service.CommentService;
import socialnetwork.user.model.User;
import socialnetwork.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;
    private final CommentMapper commentMapper;

    public CommentController(CommentService commentService,
                             UserService userService,
                             CommentMapper commentMapper) {
        this.commentService = commentService;
        this.userService = userService;
        this.commentMapper = commentMapper;
    }

    @PostMapping
    public CommentResponse createComment(@RequestBody CreateCommentRequest request) {

        User user = userService.getUserByUsername(request.username());

        Comment comment = commentService.createComment(user, request);

        return commentMapper.toCommentResponse(comment);
    }

    @GetMapping("/post/{postId}")
    public List<CommentResponse> getCommentsByPost(@PathVariable String postId) {

        return commentService.getCommentsByPost(postId)
                .stream()
                .map(commentMapper::toCommentResponse)
                .toList();
    }
}