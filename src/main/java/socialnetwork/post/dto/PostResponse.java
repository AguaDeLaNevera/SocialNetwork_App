package socialnetwork.post.dto;

import java.time.Instant;

public record PostResponse(
        String id,
        String authorUsername,
        String authorDisplayName,
        String authorAvatarUrl,
        String content,
        long likeCount,
        long commentCount,
        Instant createdAt
) {
}
