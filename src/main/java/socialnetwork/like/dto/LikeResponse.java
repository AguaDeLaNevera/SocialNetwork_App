package socialnetwork.like.dto;

import java.time.Instant;

public record LikeResponse(
        String Id,
        String username,
        String postId,
        Instant createdAt
) {
}
