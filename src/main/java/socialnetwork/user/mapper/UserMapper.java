package socialnetwork.user.mapper;

import org.springframework.stereotype.Component;
import socialnetwork.user.dto.UserResponse;
import socialnetwork.user.model.User;

@Component
public class UserMapper {
    public UserResponse toUserResponse(User user) {
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
