// Imports
import java.io.FileNotFoundException;
import java.util.*;
/**
 * UserAccess Manager class that holds accounts and performs actins
 * @author Antranig Tatarian
 */
public class UserAccessManager {
	// Fields for class
	private List<UserAccount> accounts = new ArrayList<>();
	
	/**
	 * loadAccounts method to get all the accounts from the file
	 * @param filename loads the file
	 * @throws FileNotFoundException if the file is valid
	 */
	public void loadAccounts(String filename) throws FileNotFoundException{
		Utilities.readAccountFile(filename, this);
	}
	
	/**
	 * addUser method adds the user into the accounts list
	 * @param username The username of the user
	 * @param encryptedPassword	The encrypted password of the user
	 * @throws DuplicateUserException if the user with the same username exists
	 * @throws InvalidCommandException if the provided command was invalid
	 */
	public void addUser(String username, String encryptedPassword) throws DuplicateUserException, InvalidCommandException {
		// Check for null username and password
		if(username == null || username.isEmpty()) {
			throw new InvalidCommandException("User: '"+username+"' not found\n"+"Username is null or empty."); }
		if(encryptedPassword == null || encryptedPassword.isEmpty()) {
			throw new InvalidCommandException("encryptedPassword is null or empty.\n"+"Cannot process request."); }
		//Check if the username is already in use
		for(UserAccount index : accounts) {
			if(username.equals(index.getUsername())) {
				throw new DuplicateUserException("A user with the username:'"+username+"' already exists.");
			}
		}
		// Encrypt the password
		encryptedPassword = Utilities.encryptPassword(encryptedPassword);
		// Add user to the account
		accounts.add(new UserAccount(username, encryptedPassword));
	}
	/**
	 * removeUser method that removes a specific user from the list
	 * @param username The username of the user
	 * @throws UserNotFoundException if the user could not be found
	 * @throws InvalidCommandException if the provided command was invalid
	 */
	public void removeUser(String username) throws UserNotFoundException, InvalidCommandException{
		// Check for null username
		if(username == null || username.isEmpty()) {
			throw new InvalidCommandException("User: '"+username+"' not found\n"+"Username is null or empty."); }		
		// Find and remove the account
		for (int index = 0; index < accounts.size(); index++) {
		    if (accounts.get(index).getUsername().equals(username)) {
		        accounts.remove(index);
		        return;
		    }
		}
		throw new UserNotFoundException("User with username: '" + username + "' was not found.");
	}
	/**
	 * verifyAccess method to try and access an account.
	 * Will lock if the user incorrectly tries to access.
	 * @param username The username of the user
	 * @param encryptedPassword	The encrypted password of the user
	 * @throws UserNotFoundException if the user could not be found
	 * @throws AccountLockedException if the account is already locked
	 * @throws InvalidCommandException	if the provided command was invalid
	 * @return true if no exceptions are thrown
	 */
	public boolean verifyAccess(String username, String encryptedPassword) 
	throws UserNotFoundException, AccountLockedException, InvalidCommandException, PasswordIncorrectException {
		// Check for null username
		if(username == null || username.isEmpty()) {
		throw new InvalidCommandException("User: '"+username+"' not found\n"+"Username is null or empty."); }
		// Check the password
		if (encryptedPassword == null || encryptedPassword.isBlank()) {
			throw new InvalidCommandException("password is null or empty.\n"+ "Cannot process request.");
		}
		// Loop through and search for user in the accounts list
		UserAccount user = null;
		for(UserAccount index : accounts) {
			if(index.getUsername().equals(username)) {
				user = index;
				break;
			}
		}
		// If user could not be found
		if(user == null) {
			throw new UserNotFoundException("The user: '"+username+"' was not found.");
		}
		// Check if the account is locked
		if(user.isLocked()) {
			throw new AccountLockedException("The account of user: '"+username+"' is locked.");
		}
		/*
		 *	The following checks below is to see if the password is already encrypted
		 *	If it is not it will encrypt it and check if it matches
		 *	If it is the same it will check if it matches the stored encrypted password
		 */
		if (encryptedPassword.equals(user.getEncryptedPassword())) {
		    user.resetFailureCount();
		    return true;
		}
		else {
			// Now encrypt and check the password
			try {
		        if (user.checkPassword(encryptedPassword)) { 
		            user.resetFailureCount();
		            return true;
		        }
		        // If the password is incorrect increment failure count
		        user.incrementFailure();
		        if (user.isLocked()) {
		            throw new AccountLockedException("The account of user: '" + username + "' is locked.");
		        }
		        throw new PasswordIncorrectException("Incorrect Password.");
		    // just for debugging purposes
		    } catch (PasswordIncorrectException e) {
		        user.incrementFailure();
		        if (user.isLocked()) {
		            throw new AccountLockedException("The account of user: '" + username + "' is locked.");
		        }
		        throw e;
		    }
		}
	}
}
