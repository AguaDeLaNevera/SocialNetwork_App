package socialnetwork.follow.mapper;

import org.springframework.stereotype.Component;
import socialnetwork.follow.dto.FollowResponse;
import socialnetwork.follow.model.Follow;

@Component
public class FollowMapper {

    public FollowResponse toFollowResponse(Follow follow) {

        return new FollowResponse(
                follow.getId(),
                follow.getFollowerUsername(),
                follow.getFollowedUsername(),
                follow.getCreatedAt()
        );
    }
}