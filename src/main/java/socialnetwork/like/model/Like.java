package socialnetwork.like.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("likes")
@Getter
@Setter
public class Like {

    @Id
    private String id;
    private String userId;
    private String username;
    private String postId;
    private Instant createdAt;

}
