package om.dev.jobpoint.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboardPage(Model model) {
        model.addAttribute("mensagem", "Bem vindo ao seu Dashboard!");
        return "dashboard";
    }
}
