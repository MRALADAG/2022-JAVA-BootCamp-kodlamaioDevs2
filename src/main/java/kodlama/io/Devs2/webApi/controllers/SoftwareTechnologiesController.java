package kodlama.io.Devs2.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs2.business.abstracts.SoftwareTechnologiesService;
import kodlama.io.Devs2.entities.concretes.SoftwareTechnologies;

@RestController
@RequestMapping("/api/softwaretechnologies")
public class SoftwareTechnologiesController {

	@Autowired
	private SoftwareTechnologiesService softwareTechnologiesService;

	@PostMapping("/addsoftwaretechnologies")
	public SoftwareTechnologies addSoftwareTechnologies(@RequestBody SoftwareTechnologies softwareTechnologies)
			throws Exception {
		return softwareTechnologiesService.addSoftwareTechnologies(softwareTechnologies);
	}

	@PostMapping("/updatesoftwaretechnologies")
	public SoftwareTechnologies updateSoftwareTechnologies(@RequestBody SoftwareTechnologies softwareTechnologies)
			throws Exception {
		return softwareTechnologiesService.updateSoftwareTechnologies(softwareTechnologies);
	}

	@GetMapping("/getsoftwaretechnologiesbyid")
	public SoftwareTechnologies getSoftwareTechnologiesById(@RequestParam int softwareTechnologiesId) throws Exception {
		return softwareTechnologiesService.getSoftwareTechnologiesById(softwareTechnologiesId);
	}

	@PostMapping("/deletesoftwaretechnologiesbyid")
	public void deleteSoftwareTechnologiesById(@RequestBody int softwareTechnologiesId) throws Exception {
		softwareTechnologiesService.deleteSoftwareTechnologiesById(softwareTechnologiesId);
	}

	@GetMapping("/getallsoftwaretechnologies")
	public List<SoftwareTechnologies> getAllSoftwareTechnologies() {
		return softwareTechnologiesService.getAllSoftwareTechnologies();
	}
}
