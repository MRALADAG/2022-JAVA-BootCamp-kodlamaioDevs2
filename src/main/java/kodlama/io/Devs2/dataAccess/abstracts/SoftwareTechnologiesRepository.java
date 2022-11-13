package kodlama.io.Devs2.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import kodlama.io.Devs2.entities.concretes.SoftwareTechnologies;

public interface SoftwareTechnologiesRepository extends JpaRepository<SoftwareTechnologies, Integer> {
	List<SoftwareTechnologies> findAllByNameEqualsIgnoreCase(String name);

	List<SoftwareTechnologies> findAllBySoftwareId(int softwareId);
}
