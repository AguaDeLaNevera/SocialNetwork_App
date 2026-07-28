package socialnetwork.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import socialnetwork.auth.dto.AuthUserResponse;
import socialnetwork.auth.dto.CreateUserRequest;
import socialnetwork.auth.dto.LoginRequest;
import socialnetwork.auth.service.AuthService;
import socialnetwork.auth.mapper.Mapper;
import socialnetwork.user.model.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final Mapper mapper;

    public AuthController(AuthService authService) {
        this.authService = authService;
        this.mapper = new Mapper();
    }

    @PostMapping("/login")
    public AuthUserResponse login(@RequestBody LoginRequest request) {
        User user = authService.login(request.username(), request.password());
        return mapper.toAuthUserResponse(user);
    }
    @PostMapping("/register")
    public AuthUserResponse register(@RequestBody CreateUserRequest request) {
        User user = authService.saveUser(request.username(), request.email(), request.password());
        return mapper.toAuthUserResponse(user);
    }
}
