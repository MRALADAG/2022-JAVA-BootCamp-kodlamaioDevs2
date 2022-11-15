package kodlama.io.Devs2.business.abstracts;

import java.util.List;
import kodlama.io.Devs2.dtos.software.SoftwareRequest;
import kodlama.io.Devs2.dtos.software.SoftwareResponse;
import kodlama.io.Devs2.entities.concretes.Software;

public interface SoftwareService {

	SoftwareResponse addSoftware(SoftwareRequest softwareRequest) throws Exception;

	SoftwareResponse updateSoftware(SoftwareRequest softwareRequest, int id) throws Exception;

	Software getSoftwareById(int softwareId) throws Exception;

	SoftwareResponse getSoftwareResponseById(int softwareId) throws Exception;

	void deleteSoftwareById(int softwareId) throws Exception;

	List<SoftwareResponse> getAllSoftware();

	SoftwareResponse addSoftwareTechnologyToSoftware(SoftwareRequest softwareRequest, int softwareTechnologyId)
			throws Exception;
}
