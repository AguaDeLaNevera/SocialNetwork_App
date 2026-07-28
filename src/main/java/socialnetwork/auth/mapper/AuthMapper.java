package socialnetwork.auth.mapper;

import org.springframework.stereotype.Component;
import socialnetwork.auth.dto.AuthUserResponse;
import socialnetwork.user.model.User;

@Component
public class AuthMapper {

    public AuthUserResponse toAuthUserResponse(User user) {
        return new AuthUserResponse(user.getUsername(), user.getEmail(), user.getPassword());
    }
}
