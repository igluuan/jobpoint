package om.dev.jobpoint.dtos.request.user;

public record UserRegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
