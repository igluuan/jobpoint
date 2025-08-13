package om.dev.jobpoint.service;

import lombok.RequiredArgsConstructor;
import om.dev.jobpoint.dtos.request.UserRegisterRequest;
import om.dev.jobpoint.dtos.response.UserRegisterResponse;
import om.dev.jobpoint.mapper.UserMapper;
import om.dev.jobpoint.model.User;
import om.dev.jobpoint.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserRegisterResponse register(UserRegisterRequest request){
        if (request.firstName() == null || request.lastName() == null || request.email() == null || request.password() == null) {
            throw new IllegalArgumentException("All fields are required");
        }
        User user = new UserMapper().toUser(request);
        userRepository.save(user);
        return new UserMapper().toUserRegisterResponse(user);
    }

}
