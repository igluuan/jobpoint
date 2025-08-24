package om.dev.jobpoint.config;

import lombok.RequiredArgsConstructor;
import om.dev.jobpoint.enums.Role;
import om.dev.jobpoint.model.User;
import om.dev.jobpoint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class DataSeeder implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${jobpoint.admin.email}")
    private String adminEmail;

    @Value("${jobpoint.admin.password}")
    private String adminPassword;

    @Value("${jobpoint.admin.firstName}")
    private String adminFirstName;

    @Value("${jobpoint.admin.lastName}")
    private String adminLastName;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!userRepository.existsByRole(Role.ROLE_GESTOR)) {
            String encodedPassword = passwordEncoder.encode(adminPassword);
            User admin = new User(
                    null,
                    adminFirstName + " " + adminLastName,
                    adminEmail,
                    encodedPassword,
                    Role.ROLE_GESTOR,
                    Collections.emptyList()
            );
            userRepository.save(admin);
        }
    }
}
