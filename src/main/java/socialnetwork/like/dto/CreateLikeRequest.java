package socialnetwork.like.dto;

public record CreateLikeRequest(
        String username,
        String postId
) {
}
