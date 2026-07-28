package socialnetwork.like.controller;

import org.springframework.web.bind.annotation.*;
import socialnetwork.like.dto.CreateLikeRequest;
import socialnetwork.like.dto.LikeResponse;
import socialnetwork.like.mapper.LikeMapper;
import socialnetwork.like.model.Like;
import socialnetwork.like.service.LikeService;
import socialnetwork.user.model.User;
import socialnetwork.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;
    private final UserService userService;
    private final LikeMapper likeMapper;

    public LikeController(LikeService likeService,
                          UserService userService,
                          LikeMapper likeMapper) {
        this.likeService = likeService;
        this.userService = userService;
        this.likeMapper = likeMapper;
    }

    @PostMapping
    public LikeResponse createLike(@RequestBody CreateLikeRequest request) {

        User user = userService.getUserByUsername(request.username());

        Like like = likeService.createLike(user, request);

        return likeMapper.toLikeResponse(like);
    }

    @GetMapping("/post/{postId}")
    public List<LikeResponse> getLikesByPost(@PathVariable String postId) {

        return likeService.getLikesByPost(postId)
                .stream()
                .map(likeMapper::toLikeResponse)
                .toList();
    }

    @GetMapping("/user/{userId}")
    public List<LikeResponse> getLikesByUser(@PathVariable String userId) {

        return likeService.getLikesByUser(userId)
                .stream()
                .map(likeMapper::toLikeResponse)
                .toList();
    }
}