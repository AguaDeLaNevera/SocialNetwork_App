package socialnetwork.post.mapper;

import org.springframework.stereotype.Component;
import socialnetwork.post.dto.PostResponse;
import socialnetwork.post.model.Post;

@Component
public class PostMapper {

    public PostResponse toPostResponse(Post post) {
        return new PostResponse(
                post.getId(),
                post.getAuthorUsername(),
                post.getAuthorDisplayName(),
                post.getAuthorAvatarUrl(),
                post.getContent(),
                post.getLikeCount(),
                post.getCommentCount(),
                post.getCreatedAt()
        );
    }
}
