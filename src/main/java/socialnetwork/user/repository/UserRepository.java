package socialnetwork.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import socialnetwork.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    List<User> findByDisplayName(String displayName);
    Optional<User> findByEmail(String email);
}
