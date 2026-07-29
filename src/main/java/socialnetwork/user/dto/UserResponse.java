package socialnetwork.user.dto;

public record UserResponse (
        String id,
        String username,
        String email,
        String displayName,
        String biography,
        String avatarUrl,
        String bannerUrl,
        boolean isAccountPrivate,
        long followerCount,
        long followingCount
){
}
