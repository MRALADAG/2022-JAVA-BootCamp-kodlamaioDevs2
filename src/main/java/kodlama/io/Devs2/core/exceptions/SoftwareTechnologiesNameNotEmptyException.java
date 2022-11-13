package kodlama.io.Devs2.core.exceptions;

public class SoftwareTechnologiesNameNotEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 435103658446204633L;
	private static final String ALERT = "Yazılım teknolojisi ismi boş bırakılamaz!";

	public SoftwareTechnologiesNameNotEmptyException() {
	}

	public SoftwareTechnologiesNameNotEmptyException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
