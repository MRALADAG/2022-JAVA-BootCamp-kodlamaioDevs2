package kodlama.io.Devs2.core.utilities;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import kodlama.io.Devs2.core.exceptions.SoftwareIdNotEmptyException;
import kodlama.io.Devs2.core.exceptions.SoftwareIdNotEqualException;
import kodlama.io.Devs2.core.exceptions.SoftwareNameNotEmptyException;
import kodlama.io.Devs2.core.exceptions.SoftwareNameNotEqualException;
import kodlama.io.Devs2.core.exceptions.SoftwareNotFoundException;
import kodlama.io.Devs2.dataAccess.abstracts.SoftwareRepository;
import kodlama.io.Devs2.entities.concretes.Software;

@Component
public class CheckValidityForSoftware {

	@Autowired
	private SoftwareRepository softwareRepository;

	public Exception isValid(List<Exception> logics) throws Exception {

		for (Exception error : logics) {
			if (error != null) {
				throw error;
			}

		}

		return null;

	}

	public Exception checkSoftwareId(Software software) {
		List<Exception> result = new ArrayList<>();

		softwareRepository.findById(software.getId())
				.ifPresent(item -> result.add(new SoftwareIdNotEqualException(software.toString())));

		return result.get(0);
	}

	public Exception checkSoftwareById(int softwareId) {

		return softwareRepository.findById(softwareId).isPresent() ? null
				: new SoftwareNotFoundException("\nid : " + String.valueOf(softwareId));

	}

	public Exception checkIfId(int softwareId) {

		return softwareId == 0 ? new SoftwareIdNotEmptyException("\nid : " + String.valueOf(softwareId)) : null;
	}

	public Exception checkSoftwareName(Software software) {

		return softwareRepository.findByNameContainsIgnoreCase(software.getName()).isPresent()
				? new SoftwareNameNotEqualException(software.toString())
				: null;

	}

	public Exception checkSoftwareNameIsEmptyOrNull(Software software) {
		boolean result = (software.getName() == null || software.getName().isBlank() || software.getName().isEmpty())
				? true
				: false;
		return result ? new SoftwareNameNotEmptyException(software.toString()) : null;
	}

}
