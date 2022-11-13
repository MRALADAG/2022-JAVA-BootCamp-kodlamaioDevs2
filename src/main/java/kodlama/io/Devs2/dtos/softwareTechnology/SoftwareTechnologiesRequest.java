package kodlama.io.Devs2.dtos.softwareTechnology;

import lombok.Data;

@Data
public class SoftwareTechnologiesRequest {

	private String name;
	private int softwareId;

	@Override
	public String toString() {
		return "Software : { name : " + getName() + " }";
	}

}
