package om.dev.jobpoint.dtos.response;

import java.util.UUID;

public record UserRegisterResponse(
        UUID userId,
        String username
        ) {
}
