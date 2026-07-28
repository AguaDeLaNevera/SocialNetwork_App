package socialnetwork.follow.dto;

public record CreateFollowRequest(
        String followerUsername,
        String followingUsername
) {
}