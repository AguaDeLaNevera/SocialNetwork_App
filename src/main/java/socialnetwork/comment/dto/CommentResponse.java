package socialnetwork.comment.dto;

import java.time.Instant;

public record CommentResponse(
        String id,
        String authorUsername,
        String authorDisplayName,
        String authorAvatarUrl,
        String content,
        Instant createdAt,
        boolean edited,
        boolean deleted
) {
}
