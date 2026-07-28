package socialnetwork.follow.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("follows")
@Getter
@Setter
public class Follow {

    @Id
    private String id;
    private String followerId;
    private String followerUsername;
    private String followedId;
    private String followedUsername;
    private Instant createdAt;
}
