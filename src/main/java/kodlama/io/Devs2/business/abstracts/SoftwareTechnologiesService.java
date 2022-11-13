package kodlama.io.Devs2.business.abstracts;

import java.util.List;
import kodlama.io.Devs2.entities.concretes.SoftwareTechnologies;

public interface SoftwareTechnologiesService {

	SoftwareTechnologies addSoftwareTechnologies(SoftwareTechnologies softwareTechnologies) throws Exception;

	SoftwareTechnologies updateSoftwareTechnologies(SoftwareTechnologies softwareTechnologies) throws Exception;

	SoftwareTechnologies getSoftwareTechnologiesById(int softwareTechnologiesId) throws Exception;

	void deleteSoftwareTechnologiesById(int softwareTechnologiesId) throws Exception;

	List<SoftwareTechnologies> getAllSoftwareTechnologies();

}
