package socialnetwork.post.mapper;

import socialnetwork.post.dto.PostResponse;
import socialnetwork.post.model.Post;

public class PostMapper {

    public PostResponse toPostResponse(Post post) {
        return new PostResponse();
    }
}
