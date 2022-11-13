package kodlama.io.Devs2.core.exceptions;

public class SoftwareNameNotEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8627948847769967806L;
	private static final String ALERT = "Yazılım ismi boş bırakılamaz!";

	public SoftwareNameNotEmptyException() {
	}

	public SoftwareNameNotEmptyException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
