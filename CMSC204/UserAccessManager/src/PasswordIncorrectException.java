/**
 *  Exception class for PasswordIncorrectException
 *  Throws an error when the provided password
 *  is not the same as the users password
 */
public class PasswordIncorrectException extends Exception {
	/**
	 * PasswordIncorrectException with the specified detail message.
	 * @param message The detailed message describing the error
	 */
	public PasswordIncorrectException(String message) {
		super(message);
	}

}
