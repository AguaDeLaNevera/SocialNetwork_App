package socialnetwork.post.service;

import org.springframework.stereotype.Service;
import socialnetwork.post.dto.CreatePostRequest;
import socialnetwork.post.model.Post;
import socialnetwork.post.repository.PostRepository;
import socialnetwork.user.model.User;

import java.time.Instant;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(User user, CreatePostRequest request){
        if(request.content().isBlank()){
            return null;
        }
        Post post = new Post();
        post.setAuthorId(user.getId());
        post.setAuthorUsername(user.getUsername());
        post.setAuthorDisplayName(user.getDisplayName());
        post.setAuthorAvatarUrl(user.getAvatarUrl());
        post.setContent(request.content());
        post.setCreatedAt(Instant.now());
        return postRepository.save(post);
    }
    public List<Post> getPostsByAuthor(String userId) {
        return postRepository.findByAuthorId(userId);
    }
    public List<Post> getPostsByAuthorUsername(String username) {
        return postRepository.findByAuthorUsername(username);
    }

}
