package socialnetwork.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import socialnetwork.auth.service.AuthService;
import socialnetwork.user.model.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login() {
        return "Login page";
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.saveUser(new User());
    }
}
