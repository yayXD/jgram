package world.ucode.repos;

import jdk.nashorn.internal.runtime.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import world.ucode.domain.Profile;
import world.ucode.domain.Registration;

import javax.print.DocFlavor;
import java.util.List;

@Repository
public interface ProfileRepo extends CrudRepository<Profile, Long> {
    Profile findByUsername(Registration username);
    List<Profile> findByFirstname(String firstname);
    List<Profile> findBySurname(String surname);
    List<Profile> findByCity(String city);
    List<Profile> findAByWorkPlace(String workplace);
    List<Profile> findByPosition(String position);
    Profile findByPhotoName(String photoName);
}
