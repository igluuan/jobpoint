package om.dev.jobpoint.service;

import lombok.RequiredArgsConstructor;
import om.dev.jobpoint.dtos.request.user.UserAuthenticationRequest;
import om.dev.jobpoint.dtos.request.user.UserRegisterRequest;
import om.dev.jobpoint.dtos.response.user.UserAuthenticationResponse;
import om.dev.jobpoint.dtos.response.user.UserRegisterResponse;
import om.dev.jobpoint.mapper.UserMapper;
import om.dev.jobpoint.model.User;
import om.dev.jobpoint.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;
    private final TokenService tokenService;

    public UserRegisterResponse register(UserRegisterRequest request){
        // Verifica se o e-mail já está cadastrado
        if (userRepository.existsByEmail(request.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado");
        }

        if (request.role() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role é obrigatória");
        }

        String encodedPassword = passwordEncoder.encode(request.password());
        User user = mapper.toUser(request);
        user.changePassword(encodedPassword);
        User savedUser = userRepository.save(user);
        return mapper.toUserRegisterResponse(savedUser);
    }

    public UserAuthenticationResponse login(UserAuthenticationRequest request) {
        User user = userRepository.findByEmail(request.email());
        if (user == null || !passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String token = tokenService.generateToken(user);
        return mapper.toUserAuthenticationResponse(token, tokenService.getJwtExpiry());
    }
}