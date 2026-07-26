package socialnetwork.user.mapper;

import socialnetwork.user.dto.UserResponse;
import socialnetwork.user.model.User;

public class Mapper {
    public UserResponse toUserRespone(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getDisplayName(),
                user.getBiography(),
                user.getAvatarUrl(),
                user.getBannerUrl(),
                user.isAccountPrivate(),
                user.getFollowerCount(),
                user.getFollowingCount()
        );
    }
}
