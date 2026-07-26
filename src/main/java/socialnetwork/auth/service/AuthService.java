package socialnetwork.auth.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import socialnetwork.auth.dto.CreateUserRequest;
import socialnetwork.user.model.User;
import socialnetwork.user.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(@RequestBody CreateUserRequest request) {
        return userRepository.save(user);
    }
}
