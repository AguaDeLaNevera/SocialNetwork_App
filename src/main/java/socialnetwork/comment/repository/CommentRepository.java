package socialnetwork.comment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import socialnetwork.comment.model.Comment;

import java.util.List;


public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findByPostId(String postId);

}
