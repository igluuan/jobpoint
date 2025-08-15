package om.dev.jobpoint.dtos.request.user;

public record UserAuthenticationRequest(
        String email,
        String password
) {
}
