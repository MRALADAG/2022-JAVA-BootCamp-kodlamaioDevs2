package kodlama.io.Devs2.core.exceptions;

public class SoftwareIdNotEqualException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8062421074634877770L;
	private static final String ALERT = "Aynı id bilgisine sahip yazılım eklenemez!";

	public SoftwareIdNotEqualException() {
	}

	public SoftwareIdNotEqualException(String message) {
		super("\n" + ALERT + "\n" + message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
