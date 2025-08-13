package om.dev.jobpoint.dtos.request;

public record UserAuthenticationRequest(
        String email,
        String password
) {
}
