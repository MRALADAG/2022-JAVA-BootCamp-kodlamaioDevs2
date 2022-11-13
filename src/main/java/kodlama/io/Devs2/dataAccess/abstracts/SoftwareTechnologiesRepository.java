package kodlama.io.Devs2.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.Devs2.entities.concretes.SoftwareTechnologies;

public interface SoftwareTechnologiesRepository extends JpaRepository<SoftwareTechnologies, Integer> {

	Optional<SoftwareTechnologies> findByNameContainsIgnoreCase(String name);

}
