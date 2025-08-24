package om.dev.jobpoint.repository;

import om.dev.jobpoint.enums.Role;
import om.dev.jobpoint.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByRole(Role role);
}
