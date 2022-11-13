package kodlama.io.Devs2.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.Devs2.business.abstracts.SoftwareTechnologiesService;
import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesNotFoundException;
import kodlama.io.Devs2.core.utilities.CheckValidityForSoftwareTechnologies;
import kodlama.io.Devs2.dataAccess.abstracts.SoftwareTechnologiesRepository;
import kodlama.io.Devs2.entities.concretes.SoftwareTechnologies;

@Service
public class SoftwareTechnologiesManager implements SoftwareTechnologiesService {

	@Autowired
	private SoftwareTechnologiesRepository softwareTechnologiesRepository;

	@Autowired
	private CheckValidityForSoftwareTechnologies checkValidityForSoftwareTechnologies;

	private List<Exception> checkList;

	public SoftwareTechnologiesManager() {
	}

	@Override
	public SoftwareTechnologies addSoftwareTechnologies(SoftwareTechnologies softwareTechnologies) throws Exception {
		checkList = new ArrayList<Exception>();
		checkList.add(checkValidityForSoftwareTechnologies.checkSoftwareTechnologiesName(softwareTechnologies));
		checkList.add(
				checkValidityForSoftwareTechnologies.checkSoftwareTechnologiesNameIsEmptyOrNull(softwareTechnologies));
		checkValidityForSoftwareTechnologies.isValid(checkList);

		return softwareTechnologiesRepository.save(softwareTechnologies);
	}

	@Override
	public SoftwareTechnologies updateSoftwareTechnologies(SoftwareTechnologies softwareTechnologies) throws Exception {
		checkList = new ArrayList<Exception>();
		checkList.add(checkValidityForSoftwareTechnologies.checkIfId(softwareTechnologies.getId()));
		checkList.add(
				checkValidityForSoftwareTechnologies.checkSoftwareTechnologiesNameIsEmptyOrNull(softwareTechnologies));
		checkValidityForSoftwareTechnologies.isValid(checkList);

		Optional<SoftwareTechnologies> updatedSoftwareTechnologies = softwareTechnologiesRepository
				.findById(softwareTechnologies.getId());

		if (!updatedSoftwareTechnologies.isPresent()) {
			updatedSoftwareTechnologies.orElseThrow(SoftwareTechnologiesNotFoundException::new);
		}
		return softwareTechnologiesRepository.save(softwareTechnologies);
	}

	@Override
	public SoftwareTechnologies getSoftwareTechnologiesById(int softwareTechnologiesId) throws Exception {
		checkList = new ArrayList<Exception>();
		checkList.add(checkValidityForSoftwareTechnologies.checkIfId(softwareTechnologiesId));
		checkValidityForSoftwareTechnologies.isValid(checkList);

		return softwareTechnologiesRepository.findById(softwareTechnologiesId)
				.orElseThrow(SoftwareTechnologiesNotFoundException::new);
	}

	@Override
	public void deleteSoftwareTechnologiesById(int softwareTechnologiesId) throws Exception {
		checkList = new ArrayList<Exception>();
		checkList.add(checkValidityForSoftwareTechnologies.checkIfId(softwareTechnologiesId));
		checkList.add(checkValidityForSoftwareTechnologies.checkSoftwareTechnologiesById(softwareTechnologiesId));
		checkValidityForSoftwareTechnologies.isValid(checkList);

		softwareTechnologiesRepository.deleteById(softwareTechnologiesId);
	}

	@Override
	public List<SoftwareTechnologies> getAllSoftwareTechnologies() {
		return softwareTechnologiesRepository.findAll();
	}

}
