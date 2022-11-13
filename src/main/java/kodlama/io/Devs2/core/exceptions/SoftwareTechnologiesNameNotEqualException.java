package kodlama.io.Devs2.core.exceptions;

public class SoftwareTechnologiesNameNotEqualException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2337804900523926620L;
	private static final String ALERT = "Belirtilen yazılım teknolojisi ismi bulunmaktadır!";

	public SoftwareTechnologiesNameNotEqualException() {
	}

	public SoftwareTechnologiesNameNotEqualException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
