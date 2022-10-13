package web.Lesson312.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.Lesson312.service.UserService;
import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String pageForUser (Model model, Principal principal) {
        model.addAttribute("user",userService.getUserByLogin(principal.getName()));
        return "user";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
