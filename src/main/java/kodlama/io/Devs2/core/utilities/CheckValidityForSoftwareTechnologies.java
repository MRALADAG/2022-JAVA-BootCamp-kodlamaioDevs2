package kodlama.io.Devs2.core.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesIdNotEmptyException;
import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesIdNotEqualException;
import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesNameNotEmptyException;
import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesNameNotEqualException;
import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesNotFoundException;
import kodlama.io.Devs2.dataAccess.abstracts.SoftwareTechnologiesRepository;
import kodlama.io.Devs2.entities.concretes.SoftwareTechnologies;

@Component
public class CheckValidityForSoftwareTechnologies {

	@Autowired
	private SoftwareTechnologiesRepository softwareTechnologiesRepository;

	public Exception isValid(List<Exception> logics) throws Exception {

		for (Exception error : logics) {
			if (error != null) {
				throw error;
			}

		}

		return null;

	}

	public Exception checkSoftwareTechnologiesId(SoftwareTechnologies softwareTechnologies) {

		List<Exception> result = new ArrayList<>();

		softwareTechnologiesRepository.findById(softwareTechnologies.getId()).ifPresent(
				item -> result.add(new SoftwareTechnologiesIdNotEqualException(softwareTechnologies.toString())));

		return result.get(0);
	}

	public Exception checkSoftwareTechnologiesById(int softwareTechnologiesId) {

		return softwareTechnologiesRepository.findById(softwareTechnologiesId).isPresent() ? null
				: new SoftwareTechnologiesNotFoundException("\nid : " + String.valueOf(softwareTechnologiesId));

	}

	public Exception checkIfId(int softwareTechnologiesId) {

		return softwareTechnologiesId == 0
				? new SoftwareTechnologiesIdNotEmptyException("\nid : " + String.valueOf(softwareTechnologiesId))
				: null;
	}

	public Exception checkSoftwareTechnologiesName(SoftwareTechnologies softwareTechnologies) {

		return softwareTechnologiesRepository.findByNameContainsIgnoreCase(softwareTechnologies.getName()).isPresent()
				? new SoftwareTechnologiesNameNotEqualException(softwareTechnologies.toString())
				: null;

	}

	public Exception checkSoftwareTechnologiesNameIsEmptyOrNull(SoftwareTechnologies softwareTechnologies) {
		boolean result = (softwareTechnologies.getName() == null || softwareTechnologies.getName().isBlank()
				|| softwareTechnologies.getName().isEmpty()) ? true : false;
		return result ? new SoftwareTechnologiesNameNotEmptyException(softwareTechnologies.toString()) : null;
	}

}
