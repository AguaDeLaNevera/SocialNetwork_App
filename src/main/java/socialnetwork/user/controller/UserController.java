package socialnetwork.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import socialnetwork.user.dto.UserResponse;
import socialnetwork.user.mapper.Mapper;
import socialnetwork.user.model.User;
import socialnetwork.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final Mapper mapper;

    public UserController(UserService userService, Mapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/email")
    public UserResponse getUserByEmail(@RequestParam String email){
        return mapper.toUserRespone(userService.getUserByEmail(email));
    }
    @GetMapping("/id")
    public UserResponse getUserById(@RequestParam String id){
        return mapper.toUserRespone(userService.getUserById(id));
    }
    @GetMapping("/username")
    public UserResponse getUserByUsername(@RequestParam String username){
        return mapper.toUserRespone(userService.getUserByUsername(username));
    }
    @GetMapping("/display_name")
    public List<UserResponse> getUsersByDisplayName(@RequestParam String displayName){
        return userService.getUsersByDisplayName(displayName).stream().map(mapper::toUserRespone).toList();
    }

}
