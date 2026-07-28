package socialnetwork.comment.mapper;

import org.springframework.stereotype.Component;
import socialnetwork.comment.dto.CommentResponse;
import socialnetwork.comment.model.Comment;

@Component
public class CommentMapper {

    public CommentResponse toCommentResponse(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getAuthorUsername(),
                comment.getAuthorDisplayName(),
                comment.getAuthorAvatarUrl(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.isEdited(),
                comment.isDeleted()
        );
    }

}
