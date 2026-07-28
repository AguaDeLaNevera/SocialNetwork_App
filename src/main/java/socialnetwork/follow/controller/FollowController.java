package socialnetwork.follow.controller;

import org.springframework.web.bind.annotation.*;
import socialnetwork.follow.dto.CreateFollowRequest;
import socialnetwork.follow.dto.FollowResponse;
import socialnetwork.follow.mapper.FollowMapper;
import socialnetwork.follow.model.Follow;
import socialnetwork.follow.service.FollowService;
import socialnetwork.user.model.User;
import socialnetwork.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/follows")
public class FollowController {

    private final FollowService followService;
    private final UserService userService;
    private final FollowMapper followMapper;

    public FollowController(FollowService followService,
                            UserService userService,
                            FollowMapper followMapper) {
        this.followService = followService;
        this.userService = userService;
        this.followMapper = followMapper;
    }

    @PostMapping
    public FollowResponse createFollow(@RequestBody CreateFollowRequest request) {

        User follower = userService.getUserByUsername(request.followerUsername());
        User following = userService.getUserByUsername(request.followingUsername());

        Follow follow = followService.createFollow(follower, following, request);

        return followMapper.toFollowResponse(follow);
    }

    @GetMapping("/followers/{userId}")
    public List<FollowResponse> getFollowers(@PathVariable String userId) {

        return followService.getFollowers(userId)
                .stream()
                .map(followMapper::toFollowResponse)
                .toList();
    }

    @GetMapping("/following/{userId}")
    public List<FollowResponse> getFollowing(@PathVariable String userId) {

        return followService.getFollowing(userId)
                .stream()
                .map(followMapper::toFollowResponse)
                .toList();
    }
}