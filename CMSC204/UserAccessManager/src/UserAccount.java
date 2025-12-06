/**
 * Represents a user account in the suer access manager system.
 * Tracks the username, encrypted password, failed login attempts,
 * and whether the account is currently locked.
 */
public class UserAccount extends Object{
	// Fields for the class
	private String username;
	private String encryptedPassword;
	private int failureCount = 0;
	private boolean locked = false;
	// Counter for failureCount
	public static final int MAX_FAILURES = 3;
	
	/**
	 * Constructor for UserAccount.
	 * @param username sets the username for the account
	 * @param encryptedPassword sets the password for the account
	 */
	public UserAccount(String username, String encryptedPassword) {
		// Run a check on username and password
		if(username == null || username.isBlank()) {
			throw new IllegalArgumentException("username cannot be empty");
		}
		if(encryptedPassword == null || encryptedPassword.isBlank()) {
			throw new IllegalArgumentException("Encrypted password cannot be empty");
		}
		// Set the username and password
		this.username = username;
		this.encryptedPassword = encryptedPassword;
	}
	// Following getter methods
	public String getUsername() {
		return username;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public int getFailureCount() {
		return failureCount;
	}
	public boolean isLocked() {
		return locked;
	}

	// Method to reset the failureCount
	public void resetFailureCount() {
		failureCount = 0;
	}
	// Method to increment failure
	public void incrementFailure() {
		if(!locked) {
			failureCount++;
			// Check if failureCount has reached the max failures
			if(failureCount >= MAX_FAILURES) {
				// Lock account if so.
				locked = true;
			}
		}
	}
	
	/**
	 * checkPassword method to see if the passwords match
	 * by encrypting the entered password.
	 * throws exceptions if they don't.
	 * @param password string containing the password
	 * @return true if passwords match and no exceptiosn are thrown
	 */
	public boolean checkPassword(String password) throws AccountLockedException, PasswordIncorrectException {
		// Check if the account is locked
		if(locked) {
			throw new AccountLockedException("The account of user: '"+username+"' is locked");
		}
		// Encrypt the entered password
		String other = Utilities.encryptPassword(password);
		// Check to see if encrypted passwords match
		if(!(other.equals(encryptedPassword))) {
			throw new PasswordIncorrectException("Incorrect password");
		}
		else {
			// If the account is not locked and passwords match then return true
			return true;
		}
	}
	/**
	 * Overriden equals method to determine if the username is the same.
	 * @param obj the object to compare to.
	 * @return verified if the object has the same username.
	 */
	@Override
	public boolean equals(Object obj) {
		// return variable
		boolean verified = true;
		// Check if the other username is empty
		if(obj == null) {
			verified = false;
		}
		// Create a userAccount to cast onto the object
		// Check if the usernames match
		UserAccount other = (UserAccount) obj;
		if(!(this.username.equals(other.username))) {
			verified = false;
		}
		// return the result
		return verified;
	}
	/**
	 * toString method to show the username.
	 * overrides normal toString.
	 * @return username the username of the account
	 */
	@Override
	public String toString() {
		return username;
	}
}
