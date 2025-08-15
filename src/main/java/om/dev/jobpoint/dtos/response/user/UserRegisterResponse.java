package om.dev.jobpoint.dtos.response.user;

import java.util.UUID;

public record UserRegisterResponse(
        UUID userId,
        String username
        ) {
}
