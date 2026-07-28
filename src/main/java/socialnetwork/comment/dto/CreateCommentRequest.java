package socialnetwork.comment.dto;

public record CreateCommentRequest(
        String username,
        String postId,
        String content
) {
}
