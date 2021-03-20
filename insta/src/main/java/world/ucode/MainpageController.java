package world.ucode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import world.ucode.domain.Profile;
import world.ucode.domain.Registration;
import world.ucode.repos.ProfileRepo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class MainpageController {

    @Autowired
    private ProfileRepo profileRepo;


    @GetMapping("/mainpage")
    public String show(@AuthenticationPrincipal Registration username, Model model) {
        Profile profile = profileRepo.findByUsername(username);
        if(profile != null) {
            Date data = new Date();
            Date birth = null;
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                birth = dateFormatter.parse(profile.getBirthDate());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Period period = Period.between(data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    birth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            //Long age = (data.getTime() - birth.getTime());
            // age = age / 31536000;
            String age = String.valueOf(period.getYears());
            profile.setBirthDate(age);
        } else
            model.addAttribute("profile", null);
        model.addAttribute("profile", profile);
        return "mainpage";
    }

    @PostMapping("/mainpage")
    public String doit(@AuthenticationPrincipal Registration username, Model model) {
        Profile profile = profileRepo.findByUsername(username);
        Date data = new Date();
        Date birth = null;
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birth = dateFormatter.parse(profile.getBirthDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Long age = (data.getTime() - birth.getTime()) / 31536000;
        profile.setBirthDate(age.toString());
        model.addAttribute("profile", profile);
        return "mainpage";
    }

}
