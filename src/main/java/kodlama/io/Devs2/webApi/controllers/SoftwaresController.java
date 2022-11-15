package kodlama.io.Devs2.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs2.business.abstracts.SoftwareService;
import kodlama.io.Devs2.dtos.software.SoftwareRequest;
import kodlama.io.Devs2.dtos.software.SoftwareResponse;

@RestController
@RequestMapping("/api/softwares")
public class SoftwaresController {

	@Autowired
	private SoftwareService softwareService;

	@PostMapping
	public SoftwareResponse addSoftware(@RequestBody SoftwareRequest softwareRequest) throws Exception {
		return softwareService.addSoftware(softwareRequest);
	}

	@PostMapping("/{id}")
	public SoftwareResponse addSoftwareTechnologyToSoftware(@RequestBody SoftwareRequest softwareRequest,
			@PathVariable(value = "id") int softwareTechnologyId) throws Exception {
		return softwareService.addSoftwareTechnologyToSoftware(softwareRequest, softwareTechnologyId);
	}

	@PutMapping("/{id}")
	public SoftwareResponse updateSoftware(@RequestBody SoftwareRequest softwareRequest, @PathVariable int id)
			throws Exception {
		return softwareService.updateSoftware(softwareRequest, id);
	}

	@GetMapping("/{id}")
	public SoftwareResponse getSoftwareById(@PathVariable(value = "id") int softwareId) throws Exception {
		return softwareService.getSoftwareResponseById(softwareId);
	}

//	@GetMapping("/{id}/technologies")
//	public SoftwareTechnologiesResponse getTechnologiesBySoftwareId(@PathVariable(name = "id") int softwareId)
//			throws Exception {
//		return softwareService.;
//	}

	@DeleteMapping("/{id}")
	public void deleteSoftwareById(@PathVariable int softwareId) throws Exception {
		softwareService.deleteSoftwareById(softwareId);
	}

	@GetMapping
	public List<SoftwareResponse> getAllSoftware() {
		return softwareService.getAllSoftware();
	}

}
