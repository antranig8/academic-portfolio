# CryptoManager – CMSC203 Assignment 3

This project implements two classical encryption techniques—the **Vigenere Cipher** and the **Playfair Cipher** using Java. The assignment focuses on core programming concepts including ASCII manipulation, loops, arrays, and static methods. A GUI driver was provided to interact with the encryption/decryption features, and custom JUnit tests were used to validate functionality.

---

## Project Overview

The goal of this assignment was to build a `CryptoManager` class that provides static methods for:

- Checking whether a string stays within ASCII bounds  
- Encrypting text using the **Vigenere Cipher**  
- Decrypting text using the **Vigenere Cipher**  
- Encrypting text using the **Playfair Cipher**  
- Decrypting text using the **Playfair Cipher**

A GUI (FXDriver and FXMainPane) was provided. 
All logic is built inside `CryptoManager.java`.

Custom student-writen JUnit test file was also tasked.

## Main Implemented Methods

### **`isStringInBounds(String plainText)`**
Checks whether all characters in the string fall within the allowed ASCII range.

### **`vigenereEncryption(String plainText, String key)`**
Encrypts a string using the Vigenère Cipher.  
Returns an error message if the string is out of bounds.

### **`vigenereDecryption(String encryptedText, String key)`**
Decrypts a Vigenère-encrypted string back to its plaintext form.

### **`playfairEncryption(String plainText, String key)`**
Encrypts a string using the Playfair Cipher (8×8 matrix version).  
Returns an error message if the string is out of bounds.

### **`playfairDecryption(String encryptedText, String key)`**
Decrypts Playfair-encrypted text back into plaintext.

---

## src/
- `CryptoManager.java`
- `CryptoManagerTestStudent.java`
- `FXDriver.java`
- `FXMainPane.java`

## Notes
- GUI provided by instructor (not modified)
- All required methods are inside CryptoManager
- Input strings are handled in uppercase