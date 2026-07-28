package socialnetwork.post.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("posts")
@Getter
@Setter
public class Post {

    @Id
    private String id;
    private String authorId;
    private String authorUsername;
    private String authorDisplayName;
    private String authorAvatarUrl;
    private String content;
    private long likeCount;
    private long commentCount;
    private Instant createdAt;
    private boolean edited;
}
