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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs2.business.abstracts.SoftwareTechnologiesService;
import kodlama.io.Devs2.dtos.softwareTechnology.SoftwareTechnologiesRequest;
import kodlama.io.Devs2.dtos.softwareTechnology.SoftwareTechnologiesResponse;
import kodlama.io.Devs2.entities.concretes.SoftwareTechnologies;

@RestController
@RequestMapping("/api/softwaretechnologies")
public class SoftwareTechnologiesController {

	@Autowired
	private SoftwareTechnologiesService softwareTechnologiesService;

	@PostMapping
	public SoftwareTechnologiesResponse addSoftwareTechnologies(
			@RequestBody SoftwareTechnologiesRequest softwareTechnologiesRequest) throws Exception {
		return softwareTechnologiesService.addSoftwareTechnologies(softwareTechnologiesRequest);
	}

	@PutMapping("/{id}")
	public SoftwareTechnologiesResponse updateSoftwareTechnologies(
			@RequestBody SoftwareTechnologiesRequest softwareTechnologiesRequest, @PathVariable int id)
			throws Exception {
		return softwareTechnologiesService.updateSoftwareTechnologies(softwareTechnologiesRequest);
	}

	@GetMapping("/{id}")
	public SoftwareTechnologiesResponse getSoftwareTechnologiesById(@PathVariable int softwareTechnologiesId)
			throws Exception {
		return softwareTechnologiesService.getSoftwareTechnologiesById(softwareTechnologiesId);
	}

	@DeleteMapping("/{id}")
	public void deleteSoftwareTechnologiesById(@PathVariable int softwareTechnologiesId) throws Exception {
		softwareTechnologiesService.deleteSoftwareTechnologiesById(softwareTechnologiesId);
	}

	@GetMapping
	public List<SoftwareTechnologiesResponse> getAllSoftwareTechnologies() {
		return softwareTechnologiesService.getAllSoftwareTechnologies();
	}
}
