package socialnetwork.post.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import socialnetwork.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByAuthorId(String author);
    List<Post> findByAuthorUsername(String Username);
}
