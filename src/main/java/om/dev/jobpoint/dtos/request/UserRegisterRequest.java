package om.dev.jobpoint.dtos.request;

public record UserRegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
