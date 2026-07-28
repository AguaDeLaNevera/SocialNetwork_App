package socialnetwork.user.controller;

import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/email/{email}")
    public UserResponse getUserByEmail(@PathVariable String email){
        return userMapper.toUserResponse(userService.getUserByEmail(email));
    }
    @GetMapping("/id/{id}")
    public UserResponse getUserById(@PathVariable String id){
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
