package om.dev.jobpoint.controller;

import lombok.RequiredArgsConstructor;
import om.dev.jobpoint.dtos.request.UserRegisterRequest;
import om.dev.jobpoint.dtos.response.UserRegisterResponse;
import om.dev.jobpoint.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserRegisterResponse>register(@RequestBody UserRegisterRequest request) {
        UserRegisterResponse response = userService.register(request);
        return ResponseEntity.ok(response);
    }
}
