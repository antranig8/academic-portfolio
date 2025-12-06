# UserAccessManager – CMSC 204 Project 1

A console-based authentication system that manages user accounts, verifies credentials, and enforces password security rules. This project focuses on exception handling, file I/O, SHA-256 hashing, and list-based data management.

---

## **Overview**

The program maintains a list of user accounts, each containing:

- Username  
- Encrypted (SHA-256 hashed) password  
- Failure count  
- Locked status  

Users can be added, removed, verified, and loaded from a file. Improper commands or invalid states trigger custom exceptions designed for the system.

---

## **Features**

- **Secure Password Handling**  
  Uses SHA-256 hashing (no plaintext passwords stored). Passwords are verified by hashing the input and comparing it to the stored hash.

- **Account Lockout**  
  Accounts lock automatically after **three failed login attempts**.

- **Custom Exceptions**  
  The system defines and uses:  
  - `DuplicateUserException`  
  - `UserNotFoundException`  
  - `InvalidCommandException`  
  - `AccountLockedException`  
  - `PasswordIncorrectException` 
   
- **Interactive Command Console**  
Supported commands:  
- `add [username]`  
- `remove [username]`  
- `verify [username]`  
- `load [filename]`  
- `exit`  

- **Clear, User-Friendly Output**  
Error messages are descriptive and do not print stack traces.

---

## **Technical Highlights**

- Implemented using a `List<UserAccount>` (no other Java Collections permitted).  
- Full implementation of `equals()` and `toString()` in `UserAccount`.  
- Utility class provides:
- `encryptPassword(String password)`
- `readAccountFile(UserAccessManager m, String filename)`
- Robust input validation and defensive programming design.

---