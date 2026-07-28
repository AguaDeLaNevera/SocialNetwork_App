package socialnetwork.post.dto;

public record CreatePostRequest(
        String authorUsername,
        String content
) {
}
