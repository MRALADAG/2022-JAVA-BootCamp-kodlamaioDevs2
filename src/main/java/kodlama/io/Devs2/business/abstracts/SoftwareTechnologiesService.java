package kodlama.io.Devs2.business.abstracts;

import java.util.List;
import kodlama.io.Devs2.dtos.softwareTechnology.SoftwareTechnologiesRequest;
import kodlama.io.Devs2.dtos.softwareTechnology.SoftwareTechnologiesResponse;

public interface SoftwareTechnologiesService {

	SoftwareTechnologiesResponse addSoftwareTechnologies(SoftwareTechnologiesRequest softwareTechnologiesRequest)
			throws Exception;

	SoftwareTechnologiesResponse updateSoftwareTechnologies(SoftwareTechnologiesRequest softwareTechnologiesRequest)
			throws Exception;

	SoftwareTechnologiesResponse getSoftwareTechnologiesById(int softwareTechnologiesId) throws Exception;

	void deleteSoftwareTechnologiesById(int softwareTechnologiesId) throws Exception;

	List<SoftwareTechnologiesResponse> getAllSoftwareTechnologies();

	SoftwareTechnologiesResponse getTechnologiesBySoftwareId(int softwareId);

}
