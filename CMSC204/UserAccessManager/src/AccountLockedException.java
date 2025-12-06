/**
 *  Exception class for AccountLockedException
 *  Throws an error when user tries to access
 *  an account thats been locked
 */
public class AccountLockedException extends Exception {
	/**
	 * AccountLockedException with the specified detail message.
	 * @param message The detailed message describing the error
	 */
	public AccountLockedException(String message) {
		super(message);
	}

}
