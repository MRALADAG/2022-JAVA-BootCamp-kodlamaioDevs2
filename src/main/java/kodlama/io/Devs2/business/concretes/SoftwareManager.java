package kodlama.io.Devs2.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.Devs2.business.abstracts.SoftwareService;
import kodlama.io.Devs2.business.abstracts.SoftwareTechnologiesService;
import kodlama.io.Devs2.core.exceptions.SoftwareIdNotEmptyException;
import kodlama.io.Devs2.core.exceptions.SoftwareNameNotEmptyException;
import kodlama.io.Devs2.core.exceptions.SoftwareNameNotEqualException;
import kodlama.io.Devs2.core.exceptions.SoftwareNotFoundException;
import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesNotFoundException;
import kodlama.io.Devs2.core.utilities.CheckValidityForSoftware;
import kodlama.io.Devs2.dataAccess.abstracts.SoftwareRepository;
import kodlama.io.Devs2.dataAccess.abstracts.SoftwareTechnologiesRepository;
import kodlama.io.Devs2.dtos.software.SoftwareRequest;
import kodlama.io.Devs2.dtos.software.SoftwareResponse;
import kodlama.io.Devs2.dtos.softwareTechnology.SoftwareTechnologiesResponse;
import kodlama.io.Devs2.entities.concretes.Software;
import kodlama.io.Devs2.entities.concretes.SoftwareTechnologies;

@Service
public class SoftwareManager implements SoftwareService {

	@Autowired
	private SoftwareRepository softwareRepository;

//	@Autowired
//	private SoftwareTechnologiesService softwareTechnologiesService;

	@Autowired
	private SoftwareTechnologiesRepository softwareTechnologiesRepository;

	@Autowired
	private CheckValidityForSoftware checkValidityForSoftware;

	private List<Exception> checkList;

	public SoftwareManager() {

	}

	@Override
	public SoftwareResponse addSoftware(SoftwareRequest softwareRequest) throws Exception {
//		checkList = new ArrayList<Exception>();
//		checkList.add(checkValidityForSoftware.checkSoftwareName(software));
//		checkList.add(checkValidityForSoftware.checkSoftwareNameIsEmptyOrNull(software));
//		checkValidityForSoftware.isValid(checkList);

		if (!isNameValid(softwareRequest.getName())) {
			throw new SoftwareNameNotEqualException(softwareRequest.toString());
		} else if (!isNameEmpty(softwareRequest.getName())) {
			throw new SoftwareNameNotEmptyException(softwareRequest.toString());
		}

		Software software = new Software();
		software.setName(softwareRequest.getName());

		return toModel(softwareRepository.save(software));
	}

	@Override
	public SoftwareResponse updateSoftware(SoftwareRequest softwareRequest, int id) throws Exception {
//		checkList = new ArrayList<Exception>();
//		checkList.add(checkValidityForSoftware.checkIfId(software.getId()));
//		checkList.add(checkValidityForSoftware.checkSoftwareNameIsEmptyOrNull(software));
//		checkValidityForSoftware.isValid(checkList);

//		Optional<Software> updatedSoftware = softwareRepository.findById(software.getId());
//
//		if (!updatedSoftware.isPresent()) {
//			updatedSoftware.orElseThrow(SoftwareNotFoundException::new);
//		}

		if (!isIdExist(id)) {
			throw new SoftwareIdNotEmptyException(softwareRequest.toString() + " id : " + id);
		} else if (!isNameValid(softwareRequest.getName())) {
			throw new SoftwareNameNotEmptyException(softwareRequest.toString() + " id : " + id);
		}

		Software software = softwareRepository.findById(id).get();
		software.setName(softwareRequest.getName());

		return toModel(softwareRepository.save(software));
	}

	@Override
	public SoftwareResponse getSoftwareResponseById(int softwareId) throws Exception {
//		checkList = new ArrayList<Exception>();
//		checkList.add(checkValidityForSoftware.checkIfId(softwareId));
//		checkValidityForSoftware.isValid(checkList);

		if (!checkIfId(softwareId)) {
			throw new SoftwareIdNotEmptyException("\nid : " + String.valueOf(softwareId));
		} else if (!isSoftwarePresent(softwareId)) {
			throw new SoftwareNotFoundException("\nid : " + String.valueOf(softwareId));
		}

		return toModel(softwareRepository.findById(softwareId).get());

//		return softwareRepository.findById(softwareId).orElseThrow(SoftwareNotFoundException::new);
	}

	@Override
	public void deleteSoftwareById(int softwareId) throws Exception {
		checkList = new ArrayList<Exception>();
		checkList.add(checkValidityForSoftware.checkIfId(softwareId));
		checkList.add(checkValidityForSoftware.checkSoftwareById(softwareId));
		checkValidityForSoftware.isValid(checkList);

		softwareRepository.deleteById(softwareId);
	}

	public Software getSoftwareById(int softwareId) throws Exception {

		if (!checkIfId(softwareId)) {
			throw new SoftwareIdNotEmptyException("\nid : " + String.valueOf(softwareId));
		} else if (!isSoftwarePresent(softwareId)) {
			throw new SoftwareNotFoundException("\nid : " + String.valueOf(softwareId));
		}

		return softwareRepository.findById(softwareId).get();

	}

	@Override
	public List<SoftwareResponse> getAllSoftware() {

		return softwareRepository.findAll().stream().map(item -> toModel(item)).collect(Collectors.toList());

	}

	private boolean isIdExist(int id) {
		return softwareRepository.existsById(id);
	}

	private boolean checkIfId(int softwareId) {
		return softwareId == 0 ? false : true;
	}

	private boolean isNameEmpty(String name) {
		if (name.isBlank()) {
			return false;
		}
		return true;
	}

	private boolean isNameValid(String name) {
		if (!Objects.isNull(softwareRepository.findByNameEqualsIgnoreCase(name))) {
			return false;
		}
		return true;
	}

	private boolean isSoftwarePresent(int softwareId) {
		if (!softwareRepository.findById(softwareId).isPresent()) {
			return false;
		}
		return true;
	}

	private SoftwareResponse toModel(Software software) {
		SoftwareResponse response = new SoftwareResponse();
		response.setId(software.getId());
		response.setName(software.getName());
		List<SoftwareTechnologiesResponse> softwareTechnologies = software.getSoftwareTechnologies().stream()
				.map(item -> {
					SoftwareTechnologiesResponse techResponse = new SoftwareTechnologiesResponse();
					techResponse.setId(item.getId());
					techResponse.setName(item.getName());
					techResponse.setSoftwareId(item.getSoftware().getId());
					return techResponse;
				}).collect(Collectors.toList());

		response.setSoftwareTechnologiesResponse(softwareTechnologies);
		return response;
	}

	@Override
	public SoftwareResponse addSoftwareTechnologyToSoftware(SoftwareRequest softwareRequest, int softwareTechnologyId)
			throws Exception {
//		SoftwareTechnologies addedTechnology = softwareTechnologiesService
//				.getTechnologiesBySoftwareId(softwareTechnologyId);
		SoftwareTechnologies addedTechnology = softwareTechnologiesRepository.findById(softwareTechnologyId)
				.orElseThrow(SoftwareTechnologiesNotFoundException::new);
		Software software = softwareRepository.findByNameEqualsIgnoreCase(softwareRequest.getName());
		software.addSoftwareTechnologies(addedTechnology);
		return toModel(softwareRepository.save(software));
	}

}
