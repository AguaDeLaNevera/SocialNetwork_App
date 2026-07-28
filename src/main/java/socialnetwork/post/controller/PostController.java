package socialnetwork.post.controller;

import org.springframework.web.bind.annotation.*;
import socialnetwork.post.dto.CreatePostRequest;
import socialnetwork.post.dto.PostResponse;
import socialnetwork.post.mapper.PostMapper;
import socialnetwork.post.model.Post;
import socialnetwork.post.service.PostService;
import socialnetwork.user.model.User;
import socialnetwork.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;
    private final PostMapper postMapper;

    public PostController(PostService postService,
                          UserService userService,
                          PostMapper postMapper) {
        this.postService = postService;
        this.userService = userService;
        this.postMapper = postMapper;
    }

    @PostMapping
    public PostResponse createPost(@RequestBody CreatePostRequest request) {

        User user = userService.getUserByUsername(request.authorUsername());

        Post post = postService.createPost(user, request);

        return postMapper.toPostResponse(post);
    }

    @GetMapping("/author/{authorId}")
    public List<PostResponse> getPostsByAuthor(@PathVariable String authorId) {

        return postService.getPostsByAuthor(authorId)
                .stream()
                .map(postMapper::toPostResponse)
                .toList();
    }

    @GetMapping("/username/{username}")
    public List<PostResponse> getPostsByUsername(@PathVariable String username) {

        return postService.getPostsByAuthorUsername(username)
                .stream()
                .map(postMapper::toPostResponse)
                .toList();
    }
}
