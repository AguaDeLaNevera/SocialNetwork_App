package socialnetwork.follow.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import socialnetwork.follow.model.Follow;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends MongoRepository<Follow, String> {

    List<Follow> findByFollowerId(String followerId);

    List<Follow> findByFollowingId(String followingId);

    Optional<Follow> findByFollowerIdAndFollowingId(String followerId,
                                                    String followingId);
}