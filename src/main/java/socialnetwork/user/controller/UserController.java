package socialnetwork.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import socialnetwork.user.dto.UserResponse;
import socialnetwork.user.mapper.UserMapper;
import socialnetwork.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/email")
    public UserResponse getUserByEmail(@RequestParam String email){
        return userMapper.toUserResponse(userService.getUserByEmail(email));
    }
    @GetMapping("/id")
    public UserResponse getUserById(@RequestParam String id){
        return userMapper.toUserResponse(userService.getUserById(id));
    }
    @GetMapping("/username")
    public UserResponse getUserByUsername(@RequestParam String username){
        return userMapper.toUserResponse(userService.getUserByUsername(username));
    }
    @GetMapping("/display_name")
    public List<UserResponse> getUsersByDisplayName(@RequestParam String displayName){
        return userService.getUsersByDisplayName(displayName).stream().map(userMapper::toUserResponse).toList();
    }

}
