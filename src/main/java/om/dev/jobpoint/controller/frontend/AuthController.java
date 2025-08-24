package om.dev.jobpoint.controller.frontend;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {
  
  @GetMapping("/register")
  @PreAuthorize("hasRole('GESTOR')")
  public String registerPage(Model model) {
    model.addAttribute("mensagem", "Página de Registro");
    return "register";
  }
  
  @GetMapping("/login")
  public String loginPage(Model model) {
    model.addAttribute("mensagem", "Página de Login");
    return "login";
  }
}
