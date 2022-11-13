package kodlama.io.Devs2.core.exceptions;

public class SoftwareIdNotEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7984396371525126425L;
	private static final String ALERT = "Yazılımın id bilgisi boş bırakılamaz!";

	public SoftwareIdNotEmptyException() {
	}

	public SoftwareIdNotEmptyException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
