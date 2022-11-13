package kodlama.io.Devs2.dataAccess.abstracts;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.Devs2.entities.concretes.Software;

public interface SoftwareRepository extends JpaRepository<Software, Integer> {
	Optional<Software> findByNameContainsIgnoreCase(String name);
}
