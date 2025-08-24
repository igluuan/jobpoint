package om.dev.jobpoint.mapper;

import org.springframework.stereotype.Component;
import om.dev.jobpoint.model.User;
import om.dev.jobpoint.dtos.request.user.UserRegisterRequest;
import om.dev.jobpoint.dtos.response.user.UserAuthenticationResponse;
import om.dev.jobpoint.dtos.response.user.UserRegisterResponse;
import java.util.Collections;

@Component
public class UserMapper {
    public User toUser(UserRegisterRequest request) {
        String username = request.firstName() + " " + request.lastName();
        return new User(
                null,
                username,
                request.email(),
                request.password(),
                request.role(),
                Collections.emptyList()
        );
    }

    public UserRegisterResponse toUserRegisterResponse(User user) {
        return new UserRegisterResponse(
                user.getId(),
                user.getUsername()
        );
    }

    public UserAuthenticationResponse toUserAuthenticationResponse(String token, long expiresIn) {
        return new UserAuthenticationResponse(
                token,
                expiresIn
        );
    }
}
