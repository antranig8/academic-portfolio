/**
 *  Exception class for DuplicateUserException
 *  Throws an error when it detects that another user
 *  already exists in the system
 */
public class DuplicateUserException extends Exception {
	/**
	 * DuplicateUserException with the specified detail message.
	 * @param message The detailed message describing the error
	 */
	public DuplicateUserException(String message) {
		super(message);
	}

}
