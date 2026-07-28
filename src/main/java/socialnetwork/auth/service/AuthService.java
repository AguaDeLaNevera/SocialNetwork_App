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

    public User saveUser(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User login(String username, String password){
        User user = userRepository.findByUsername(username).orElse(null);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }
}
