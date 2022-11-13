package kodlama.io.Devs2.core.exceptions;

public class SoftwareNameNotEqualException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8852044433139467958L;
	private static final String ALERT = "Aynı isme sahip yazılım eklenemez!";

	public SoftwareNameNotEqualException() {
	}

	public SoftwareNameNotEqualException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
