package kodlama.io.Devs2.core.exceptions;

public class SoftwareNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7975783000249709651L;
	private static final String ALERT = "Belirtilen yazılım bulunmamaktadır!";

	public SoftwareNotFoundException() {
	}

	public SoftwareNotFoundException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
