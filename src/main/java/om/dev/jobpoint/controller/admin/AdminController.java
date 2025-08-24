package om.dev.jobpoint.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ROLE_GESTOR')")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Admin access granted");
    }
}
