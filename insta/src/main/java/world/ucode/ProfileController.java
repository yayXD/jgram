package world.ucode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import world.ucode.domain.Profile;
import world.ucode.domain.Registration;
import world.ucode.repos.ProfileRepo;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ProfileController {

    @Value("E:")
    private String uploadPath;

    @Autowired
    private ProfileRepo profileRepo;

    @GetMapping("/profile")
    public String make() {
        return "profile";
    }

    @PostMapping("/profile")
    public String makeProfile(@AuthenticationPrincipal Registration username, @RequestParam String firstname,
                              @RequestParam String surname, @RequestParam String birthDate,
                              @RequestParam("sex") String sex, @RequestParam String city,
                              @RequestParam("file") MultipartFile file,
                              @RequestParam String workPlace, @RequestParam String position,
                              @RequestParam String bio, Model model) throws IOException {
        Profile profile = profileRepo.findByUsername(username);
        if(profile == null) {
            if (file != null) {
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                String resultFilename = uuidFile + "." + file.getOriginalFilename();
                file.transferTo(new File(uploadPath + "/" + resultFilename));
                profile  = new Profile(username, firstname, surname, birthDate, sex, city, resultFilename, workPlace,
                        position, bio);
                //profile.setPhotoName(resultFilename);
                profileRepo.save(profile);
                model.addAttribute("profile", "Вы создали профиль");
            }
            model.addAttribute("profile", "Не получилось загрузить фото");
        }
        model.addAttribute("profile", "У Вас создан профиль");
        return "profile";
    }
}
