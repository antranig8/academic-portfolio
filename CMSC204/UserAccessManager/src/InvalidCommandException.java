/**
 *  Exception class for InvalidCommandException
 *  Throws an error when the command is invalid
 *  or contains a missing argument
 */
public class InvalidCommandException extends Exception {
	/**
	 * InvalidCommandException with the specified detail message.
	 * @param message The detailed message describing the error
	 */
	public InvalidCommandException(String message) {
		super(message);
	}

}
