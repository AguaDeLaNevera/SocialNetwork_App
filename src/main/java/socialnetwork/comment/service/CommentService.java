package socialnetwork.comment.service;

import org.springframework.stereotype.Service;
import socialnetwork.comment.dto.CreateCommentRequest;
import socialnetwork.comment.model.Comment;
import socialnetwork.comment.repository.CommentRepository;
import socialnetwork.post.model.Post;
import socialnetwork.post.repository.PostRepository;
import socialnetwork.user.model.User;

import java.time.Instant;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public Comment createComment(User user, CreateCommentRequest request){
        Comment comment = new Comment();
        comment.setPostId(request.postId());
        comment.setAuthorId(user.getId());
        comment.setAuthorUsername(user.getUsername());
        comment.setAuthorDisplayName(user.getDisplayName());
        comment.setAuthorAvatarUrl(user.getAvatarUrl());
        comment.setContent(request.content());
        comment.setCreatedAt(Instant.now());
        comment.setEdited(false);
        comment.setDeleted(false);

        Post post = postRepository.findById(request.postId()).orElse(null);
        if(post != null){
            post.setCommentCount(post.getCommentCount() + 1);
            postRepository.save(post);
        }

        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPost(String postId){
        return commentRepository.findByPostId(postId);
    }
}
