package kodlama.io.Devs2.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.Devs2.business.abstracts.SoftwareService;
import kodlama.io.Devs2.core.exceptions.SoftwareNotFoundException;
import kodlama.io.Devs2.core.utilities.CheckValidityForSoftware;
import kodlama.io.Devs2.dataAccess.abstracts.SoftwareRepository;
import kodlama.io.Devs2.entities.concretes.Software;

@Service
public class SoftwareManager implements SoftwareService {

	@Autowired
	private SoftwareRepository softwareRepository;

	@Autowired
	private CheckValidityForSoftware checkValidityForSoftware;

	private List<Exception> checkList;

	public SoftwareManager() {

	}

	@Override
	public Software addSoftware(Software software) throws Exception {
		checkList = new ArrayList<Exception>();
		checkList.add(checkValidityForSoftware.checkSoftwareName(software));
		checkList.add(checkValidityForSoftware.checkSoftwareNameIsEmptyOrNull(software));
		checkValidityForSoftware.isValid(checkList);

		return softwareRepository.save(software);
	}

	@Override
	public Software updateSoftware(Software software) throws Exception {
		checkList = new ArrayList<Exception>();
		checkList.add(checkValidityForSoftware.checkIfId(software.getId()));
		checkList.add(checkValidityForSoftware.checkSoftwareNameIsEmptyOrNull(software));
		checkValidityForSoftware.isValid(checkList);

		Optional<Software> updatedSoftware = softwareRepository.findById(software.getId());

		if (!updatedSoftware.isPresent()) {
			updatedSoftware.orElseThrow(SoftwareNotFoundException::new);
		}

		return softwareRepository.save(software);
	}

	@Override
	public Software getSoftwareById(int softwareId) throws Exception {
		checkList = new ArrayList<Exception>();
		checkList.add(checkValidityForSoftware.checkIfId(softwareId));
		checkValidityForSoftware.isValid(checkList);

		return softwareRepository.findById(softwareId).orElseThrow(SoftwareNotFoundException::new);
	}

	@Override
	public void deleteSoftwareById(int softwareId) throws Exception {
		checkList = new ArrayList<Exception>();
		checkList.add(checkValidityForSoftware.checkIfId(softwareId));
		checkList.add(checkValidityForSoftware.checkSoftwareById(softwareId));
		checkValidityForSoftware.isValid(checkList);

		softwareRepository.deleteById(softwareId);
	}

	@Override
	public List<Software> getAllSoftware() {
		return softwareRepository.findAll();
	}

}
