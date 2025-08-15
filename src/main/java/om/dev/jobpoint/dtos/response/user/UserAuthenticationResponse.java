package om.dev.jobpoint.dtos.response.user;

public record UserAuthenticationResponse(
        String accessToken,
        Long ExpiresIn
) {
}
