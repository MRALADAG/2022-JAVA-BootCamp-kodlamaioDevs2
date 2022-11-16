package kodlama.io.Devs2.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs2.business.abstracts.SoftwareService;
import kodlama.io.Devs2.business.abstracts.SoftwareTechnologiesService;
import kodlama.io.Devs2.core.exceptions.SoftwareNotFoundException;
import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesIdNotEmptyException;
import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesNameNotEmptyException;
import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesNameNotEqualException;
import kodlama.io.Devs2.core.exceptions.SoftwareTechnologiesNotFoundException;
import kodlama.io.Devs2.core.utilities.CheckValidityForSoftwareTechnologies;
import kodlama.io.Devs2.dataAccess.abstracts.SoftwareTechnologiesRepository;
import kodlama.io.Devs2.dtos.softwareTechnology.SoftwareTechnologiesRequest;
import kodlama.io.Devs2.dtos.softwareTechnology.SoftwareTechnologiesResponse;
import kodlama.io.Devs2.entities.concretes.SoftwareTechnologies;

@Service
public class SoftwareTechnologiesManager implements SoftwareTechnologiesService {

	@Autowired
	private SoftwareTechnologiesRepository softwareTechnologiesRepository;

	@Autowired
	private SoftwareService softwareService;

	@Autowired
	private CheckValidityForSoftwareTechnologies checkValidityForSoftwareTechnologies;

	private List<Exception> checkList;

	public SoftwareTechnologiesManager() {
	}

	@Override
	public SoftwareTechnologiesResponse addSoftwareTechnologies(SoftwareTechnologiesRequest softwareTechnologiesRequest)
			throws Exception {
//		checkList = new ArrayList<Exception>();
//		checkList.add(checkValidityForSoftwareTechnologies.checkSoftwareTechnologiesName(softwareTechnologies));
//		checkList.add(
//				checkValidityForSoftwareTechnologies.checkSoftwareTechnologiesNameIsEmptyOrNull(softwareTechnologies));
//		checkValidityForSoftwareTechnologies.isValid(checkList);

		if (!isNameValid(softwareTechnologiesRequest.getName())) {
			throw new SoftwareTechnologiesNameNotEqualException(softwareTechnologiesRequest.toString());
		} else if (!isNameEmpty(softwareTechnologiesRequest.getName())) {
			throw new SoftwareTechnologiesNameNotEmptyException(softwareTechnologiesRequest.toString());
		}

		SoftwareTechnologies softwareTechnologies = new SoftwareTechnologies();
		softwareTechnologies.setName(softwareTechnologiesRequest.getName());

		return toModel(softwareTechnologiesRepository.save(softwareTechnologies));
	}
//	
//	@PostMapping("/addsoftwaretechnologiestosoftware/{softwaretechnologyid}/{softwareid}")
//	public SoftwareTechnologiesResponse<? extends Object> addSoftwareTechnologiesToSoftware(
//			@PathVariable(value = "softwaretechnologyid")int softwaretechnologyid,@PathVariable(value = "softwareid") int softwareid) {
//		
//		SoftwareTechnologies softwareTechnologies=softwareTechnologiesRepository.findById(softwaretechnologyid).orElseThrow(SoftwareTechnologiesNotFoundException::new);
//		
//		SoftwareTechnologiesResponse softwareTechnologiesResponse=softwareRepository.findById(softwareid).map(software->{			
//			SoftwareTechnologiesResponse  updatedResponse=toModel(softwareTechnologies);
//			return updatedResponse.setSoftwareId(softwareid);
//		});
//	}
//	

	public SoftwareTechnologiesResponse addSoftwareTechnologiesToSoftware(
			SoftwareTechnologiesRequest softwareTechnologiesRequest) throws Exception {
		if (isNameValid(softwareTechnologiesRequest.getName())) {
			throw new SoftwareTechnologiesNameNotEqualException(softwareTechnologiesRequest.toString());
		}
		if (!isSoftwareIdPresent(softwareTechnologiesRequest.getSoftwareId())) {
			throw new SoftwareNotFoundException(String.valueOf(softwareTechnologiesRequest.getSoftwareId()));
		}

		SoftwareTechnologies softwareTechnologies = new SoftwareTechnologies();
		softwareTechnologies.setName(softwareTechnologiesRequest.getName());
		softwareTechnologies.setSoftware(softwareService.getSoftwareById(softwareTechnologiesRequest.getSoftwareId()));

		return toModel(softwareTechnologiesRepository.save(softwareTechnologies));
	}

	@Override
	public SoftwareTechnologiesResponse updateSoftwareTechnologies(
			SoftwareTechnologiesRequest softwareTechnologiesRequest) throws Exception {
//		checkList = new ArrayList<Exception>();
//		checkList.add(checkValidityForSoftwareTechnologies.checkIfId(softwareTechnologies.getId()));
//		checkList.add(
//				checkValidityForSoftwareTechnologies.checkSoftwareTechnologiesNameIsEmptyOrNull(softwareTechnologies));
//		checkValidityForSoftwareTechnologies.isValid(checkList);
//
//		Optional<SoftwareTechnologies> updatedSoftwareTechnologies = softwareTechnologiesRepository
//				.findById(softwareTechnologies.getId());
//
//		if (!updatedSoftwareTechnologies.isPresent()) {
//			updatedSoftwareTechnologies.orElseThrow(SoftwareTechnologiesNotFoundException::new);
//		}

		if (!checkIfId(softwareTechnologiesRequest.getSoftwareId())) {
			throw new SoftwareTechnologiesIdNotEmptyException(softwareTechnologiesRequest.toString());
		} else if (!isNameEmpty(softwareTechnologiesRequest.getName())) {
			throw new SoftwareTechnologiesNameNotEmptyException(softwareTechnologiesRequest.toString());
		} else if (!isSoftwareTechnologyPresent(softwareTechnologiesRequest.getSoftwareId())) {
			throw new SoftwareTechnologiesNotFoundException(softwareTechnologiesRequest.toString());
		}

		SoftwareTechnologies softwareTechnologies = new SoftwareTechnologies();
		softwareTechnologies.setName(softwareTechnologiesRequest.getName());

		return toModel(softwareTechnologiesRepository.save(softwareTechnologies));
	}

	@Override
	public SoftwareTechnologiesResponse getSoftwareTechnologiesById(int softwareTechnologiesId) throws Exception {
//		checkList = new ArrayList<Exception>();
//		checkList.add(checkValidityForSoftwareTechnologies.checkIfId(softwareTechnologiesId));
//		checkValidityForSoftwareTechnologies.isValid(checkList);

//		return softwareTechnologiesRepository.findById(softwareTechnologiesId)
//				.orElseThrow(SoftwareTechnologiesNotFoundException::new);

		if (!checkIfId(softwareTechnologiesId)) {
			throw new SoftwareTechnologiesIdNotEmptyException("\nid : " + String.valueOf(softwareTechnologiesId));
		} else if (!isSoftwareTechnologyPresent(softwareTechnologiesId)) {
			throw new SoftwareTechnologiesNotFoundException("\nid : " + String.valueOf(softwareTechnologiesId));
		}

		return toModel(softwareTechnologiesRepository.findById(softwareTechnologiesId).get());
	}

	@Override
	public void deleteSoftwareTechnologiesById(int softwareTechnologiesId) throws Exception {
//		checkList = new ArrayList<Exception>();
//		checkList.add(checkValidityForSoftwareTechnologies.checkIfId(softwareTechnologiesId));
//		checkList.add(checkValidityForSoftwareTechnologies.checkSoftwareTechnologiesById(softwareTechnologiesId));
//		checkValidityForSoftwareTechnologies.isValid(checkList);

		if (!checkIfId(softwareTechnologiesId)) {
			throw new SoftwareTechnologiesIdNotEmptyException("\nid : " + String.valueOf(softwareTechnologiesId));
		} else if (!isSoftwareTechnologyPresent(softwareTechnologiesId)) {
			throw new SoftwareTechnologiesNotFoundException("\nid : " + String.valueOf(softwareTechnologiesId));
		}

		softwareTechnologiesRepository.deleteById(softwareTechnologiesId);
	}

	@Override
	public List<SoftwareTechnologiesResponse> getAllSoftwareTechnologies() {
		return softwareTechnologiesRepository.findAll().stream().map(item -> toModel(item))
				.collect(Collectors.toList());
	}

	private boolean isIdExist(int softwareTechnologiesId) {
		return softwareTechnologiesRepository.existsById(softwareTechnologiesId);
	}

	private boolean checkIfId(int softwareTechnologiesId) {
		return softwareTechnologiesId == 0 ? false : true;
	}

	private boolean isNameEmpty(String name) {
		if (name.isBlank()) {
			return false;
		}
		return true;
	}

	private boolean isNameValid(String name) {
		if (!softwareTechnologiesRepository.findAllByNameEqualsIgnoreCase(name).isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean isSoftwareTechnologyPresent(int softwareTechnologiesId) {
		if (!softwareTechnologiesRepository.findById(softwareTechnologiesId).isPresent()) {
			return false;
		}
		return true;
	}

	private boolean isSoftwareIdPresent(int softwareId) throws Exception {
		if (Objects.nonNull(softwareService.getSoftwareById(softwareId))) {
			return true;
		}
		return false;
	}

	private SoftwareTechnologiesResponse toModel(SoftwareTechnologies softwareTechnologies) {
		SoftwareTechnologiesResponse response = new SoftwareTechnologiesResponse();
		response.setId(softwareTechnologies.getId());
		response.setName(softwareTechnologies.getName());
		response.setSoftwareId(softwareTechnologies.getSoftware().getId());
		return response;
	}

	@Override
	public SoftwareTechnologiesResponse findTechnologiesById(int softwareTechnologyid) throws Exception {
		return toModel(softwareTechnologiesRepository.findById(softwareTechnologyid)
				.orElseThrow(SoftwareTechnologiesNotFoundException::new));
	}

	@Override
	public SoftwareTechnologies getTechnologiesBySoftwareId(int softwareTechnologyid) throws Exception {
		return softwareTechnologiesRepository.findById(softwareTechnologyid).orElseThrow(
				() -> new SoftwareTechnologiesNotFoundException("\nid: " + String.valueOf(softwareTechnologyid)));
//		.orElseThrow(SoftwareTechnologiesNotFoundException::new);
	}

}