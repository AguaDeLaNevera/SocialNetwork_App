package socialnetwork.like.service;

import org.springframework.stereotype.Service;
import socialnetwork.like.dto.CreateLikeRequest;
import socialnetwork.like.model.Like;
import socialnetwork.like.repository.LikeRepository;
import socialnetwork.post.model.Post;
import socialnetwork.post.repository.PostRepository;
import socialnetwork.user.model.User;

import java.time.Instant;
import java.util.List;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    public LikeService(LikeRepository likeRepository,
                       PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
    }

    public Like createLike(User user,
                           CreateLikeRequest request) {

        if(likeRepository.findByUserIdAndPostId(user.getId(), request.postId()).isPresent()){
            return null;
        }

        Like like = new Like();

        like.setUserId(user.getId());
        like.setUsername(user.getUsername());
        like.setPostId(request.postId());
        like.setCreatedAt(Instant.now());

        Post post = postRepository.findById(request.postId()).orElse(null);

        if (post != null) {
            post.setLikeCount(post.getLikeCount() + 1);
            postRepository.save(post);
        }

        return likeRepository.save(like);
    }


    public List<Like> getLikesByPost(String postId) {
        return likeRepository.findByPostId(postId);
    }

    public List<Like> getLikesByUser(String userId) {
        return likeRepository.findByUserId(userId);
    }
}