package kodlama.io.Devs2.dtos.software;

import java.util.List;
import kodlama.io.Devs2.dtos.softwareTechnology.SoftwareTechnologiesResponse;
import lombok.Data;

@Data
public class SoftwareResponse {

	private int id;
	private String name;
	private List<SoftwareTechnologiesResponse> softwareTechnologiesResponse;

}
