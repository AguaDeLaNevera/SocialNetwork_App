package socialnetwork.like.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import socialnetwork.like.model.Like;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends MongoRepository<Like, String> {

    List<Like> findByPostId(String postId);

    List<Like> findByUserId(String userId);

    Optional<Like> findByUserIdAndPostId(String userId, String postId);

}