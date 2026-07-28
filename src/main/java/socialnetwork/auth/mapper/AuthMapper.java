package socialnetwork.auth.mapper;

import socialnetwork.auth.dto.AuthUserResponse;
import socialnetwork.user.model.User;

public class AuthMapper {

    public AuthUserResponse toAuthUserResponse(User user) {
        return new AuthUserResponse(user.getUsername(), user.getEmail(), user.getPassword());
    }
}
