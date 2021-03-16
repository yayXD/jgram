package world.ucode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import world.ucode.domain.Mes;
import world.ucode.domain.Registration;
import world.ucode.repos.MesRepo;
import world.ucode.repos.RegistrationRepo;

import java.util.Date;
import java.util.Iterator;

@Controller
public class MesController {

    @Autowired
    RegistrationRepo registrationRepo;

    @Autowired
    MesRepo mesRepo;

    @GetMapping("/mes")
    public String getReceiver(@AuthenticationPrincipal Registration registration, Model model) {
        Iterable<Registration> reg = registrationRepo.findAll();
        Iterator<Registration> iterator = reg.iterator();
        while(iterator.hasNext()) {
            Registration r = iterator.next();
            if (r.getUsername().equals(registration.getUsername()) == true)
                iterator.remove();
        }
            model.addAttribute("users", reg);
        return "mes";
    }

    @PostMapping("/mes")
    public String makeMes(@AuthenticationPrincipal Registration registration, @RequestParam("receiv") String receiver,
                              @RequestParam String mes) {
        if(registration.getUsername().equals(receiver) != true) {
            Date date = new Date();
            Mes chat = new Mes(registration, receiver, mes, date.toString());
            mesRepo.save(chat);
            Registration reg = registrationRepo.findByUsername(receiver);
            Mes mes2 = new Mes(reg, registration.getUsername(), mes, date.toString());
            mesRepo.save(mes2);
        }
        return "redirect:/chat";
    }
}
