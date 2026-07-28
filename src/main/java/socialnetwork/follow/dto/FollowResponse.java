package socialnetwork.follow.dto;

import java.time.Instant;

public record FollowResponse(
        String id,
        String followerUsername,
        String followingUsername,
        Instant createdAt
) {
}