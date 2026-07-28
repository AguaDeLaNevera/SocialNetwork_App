package socialnetwork.comment.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("comments")
@Getter
@Setter
public class Comment {

    @Id
    private String id;
    private String postId;
    private String authorId;
    private String authorUsername;
    private String authorDisplayName;
    private String authorAvatarUrl;
    private String content;
    private Instant createdAt;
    private boolean edited;
    private boolean deleted;
}
