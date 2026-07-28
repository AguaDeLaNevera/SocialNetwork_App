package socialnetwork.like.mapper;

import org.springframework.stereotype.Component;
import socialnetwork.like.dto.LikeResponse;
import socialnetwork.like.model.Like;

@Component
public class LikeMapper {

    public LikeResponse toLikeResponse(Like like) {

        return new LikeResponse(
                like.getId(),
                like.getUsername(),
                like.getPostId(),
                like.getCreatedAt()
        );
    }
}