/**
 *  Exception class for UserNotFoundException
 *  Throws an error when it can't find the user
 */
public class UserNotFoundException extends Exception {
	/**
	 * UserNotFoundException with the specified detail message.
	 * @param message The detailed message describing the error
	 */
	public UserNotFoundException(String message) {
		super(message);
	}

}
