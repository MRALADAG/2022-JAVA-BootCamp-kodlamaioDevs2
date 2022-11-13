package kodlama.io.Devs2.core.exceptions;

public class SoftwareTechnologiesNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3198189317031323812L;
	private static final String ALERT = "Belirtilen yazılım teknolojisi bulunmamaktadır!";

	public SoftwareTechnologiesNotFoundException() {
	}

	public SoftwareTechnologiesNotFoundException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
