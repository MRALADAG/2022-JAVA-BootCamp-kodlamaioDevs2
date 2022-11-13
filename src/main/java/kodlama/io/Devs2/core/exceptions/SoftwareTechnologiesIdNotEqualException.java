package kodlama.io.Devs2.core.exceptions;

public class SoftwareTechnologiesIdNotEqualException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6779753017276369358L;
	private static final String ALERT = "Yazılım teknolojisi id bilgisi aynı olamaz!";

	public SoftwareTechnologiesIdNotEqualException() {
	}

	public SoftwareTechnologiesIdNotEqualException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
