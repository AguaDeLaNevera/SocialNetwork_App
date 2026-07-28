package socialnetwork.follow.service;

import org.springframework.stereotype.Service;
import socialnetwork.follow.dto.CreateFollowRequest;
import socialnetwork.follow.model.Follow;
import socialnetwork.follow.repository.FollowRepository;
import socialnetwork.user.model.User;
import socialnetwork.user.repository.UserRepository;

import java.time.Instant;
import java.util.List;

@Service
public class FollowService {

    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    public FollowService(FollowRepository followRepository,
                         UserRepository userRepository) {
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    public Follow createFollow(User follower,
                               User following,
                               CreateFollowRequest request) {

        if(followRepository.findByFollowerIdAndFollowingId(follower.getId(), following.getId()).isPresent()){
            return null;
        }
        if (follower.getId().equals(following.getId())) {
            return null;
        }

        Follow follow = new Follow();

        follow.setFollowerId(follower.getId());
        follow.setFollowerUsername(follower.getUsername());

        follow.setFollowedId(following.getId());
        follow.setFollowedUsername(following.getUsername());

        follow.setCreatedAt(Instant.now());

        follower.setFollowingCount(follower.getFollowingCount() + 1);
        following.setFollowerCount(following.getFollowerCount() + 1);

        userRepository.save(follower);
        userRepository.save(following);

        return followRepository.save(follow);
    }

    public List<Follow> getFollowing(String followerId) {
        return followRepository.findByFollowerId(followerId);
    }

    public List<Follow> getFollowers(String followingId) {
        return followRepository.findByFollowingId(followingId);
    }
}