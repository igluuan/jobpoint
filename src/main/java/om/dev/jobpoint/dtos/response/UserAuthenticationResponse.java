package om.dev.jobpoint.dtos.response;

public record UserAuthenticationResponse(
        String accessToken,
        Long ExpiresIn
) {
}
