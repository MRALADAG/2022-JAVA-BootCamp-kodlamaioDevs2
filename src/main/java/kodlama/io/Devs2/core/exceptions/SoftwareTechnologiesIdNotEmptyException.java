package kodlama.io.Devs2.core.exceptions;

public class SoftwareTechnologiesIdNotEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6187804232701296434L;
	private static final String ALERT = "Yazılım teknolojisinin id bilgisi boş bırakılamaz!";

	public SoftwareTechnologiesIdNotEmptyException() {
	}

	public SoftwareTechnologiesIdNotEmptyException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
