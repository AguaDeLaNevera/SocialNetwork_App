package socialnetwork.auth.dto;

public record AuthUserResponse(
        String username,
        String email,
        String password
) {
}
