package kodlama.io.Devs2.webApi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.Devs2.entities.concretes.Software;
import kodlama.io.Devs2.business.abstracts.SoftwareService;

@RestController
@RequestMapping("/api/softwares")
public class SoftwaresController {

	@Autowired
	private SoftwareService softwareService;

	@PostMapping("/addsoftware")
	public Software addSoftware(@RequestBody Software software) throws Exception {
		return softwareService.addSoftware(software);
	}

	@PostMapping("/updatesoftware")
	public Software updateSoftware(@RequestBody Software software) throws Exception {
		return softwareService.updateSoftware(software);
	}

	@GetMapping("/getsoftwarebyid")
	public Software getSoftwareById(@RequestParam int softwareId) throws Exception {
		return softwareService.getSoftwareById(softwareId);
	}

	@PostMapping("/deletesoftwarebyid")
	public void deleteSoftwareById(@RequestBody int softwareId) throws Exception {
		softwareService.deleteSoftwareById(softwareId);
	}

	@GetMapping("/getallsoftware")
	public List<Software> getAllSoftware() {
		return softwareService.getAllSoftware();
	}

}
