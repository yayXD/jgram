package world.ucode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import world.ucode.domain.Registration;
import world.ucode.service.RegistrationService;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String main() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(Registration registration, Model model) {
//    public String addUser(@RequestParam String username, @RequestParam String password,
//                          @RequestParam String password2, @RequestParam String email, Model model) {

        if (registration.getUsername() != null && registration.getPassword() != null) {
           if(registration.getPassword().equals(registration.getPassword2()) == true) {
                if (registrationService.addUser(registration)) {
                    model.addAttribute("mes", "Вы зарегистрированы");
                } else
                    model.addAttribute("mes", "Этот логин уже существует");
            } else
                model.addAttribute("mes", "Поля пароль и подтверждение пароля отличаются");
        } else
            model.addAttribute("mes", "Заполните все поля формы");
        return "registration";
    }
}

