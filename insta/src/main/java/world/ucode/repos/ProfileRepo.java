package world.ucode.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import world.ucode.domain.Profile;
import world.ucode.domain.Registration;

@Repository
public interface ProfileRepo extends CrudRepository<Profile, Long> {
    Profile findByUsername(Registration username);
}
