package kodlama.io.Devs2.dtos.software;

import lombok.Data;

@Data
public class SoftwareRequest {

	private String name;

	@Override
	public String toString() {
		return "Software : { name : " + getName() + " }";
	}
}
