package kodlama.io.Devs2.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.Devs2.entities.concretes.Software;

public interface SoftwareRepository extends JpaRepository<Software, Integer> {
	Software findByNameEqualsIgnoreCase(String name);
}
