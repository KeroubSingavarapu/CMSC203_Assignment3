public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
		for (int i = 0; i < plainText.length(); i++) {
			
			char currentChar = plainText.charAt(i);
			
			if (currentChar > UPPER_BOUND || currentChar < LOWER_BOUND) {  // Checks if current character is within bounds of chars for encryption
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String caesarEncrypt = "";  //Holds encrypted string
		
		for (int i = 0; i < plainText.length(); i++) {
			
			int currentChar = (int)plainText.charAt(i); 
			
			int charEncrypt = currentChar + key; // Encrypts current char with key 
			
			while (charEncrypt > (int)UPPER_BOUND) {  //Checks if encrypted char is out of bounds after adding key
				charEncrypt -= RANGE;   			// Gets encrypted char back in acceptable bounds
			}
			
			caesarEncrypt += (char)charEncrypt;		
		}
		
		return caesarEncrypt;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String bellasoEncrypt = "";  //Holds encrypted string
		
		for (int i = 0; i < plainText.length(); i++) {
			
			int currentChar = (int)plainText.charAt(i);
			int currentKeyChar = (int)bellasoStr.charAt(i%bellasoStr.length());	//determines the key char used to encrypt the current char 
			
			int charEncrypt = currentChar + currentKeyChar;
			
			while (charEncrypt > (int)UPPER_BOUND) {
				charEncrypt -= RANGE;
			}
			
			bellasoEncrypt += (char)charEncrypt;
		}
		
		return bellasoEncrypt; 
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedCaesar = "";		//Holds decrypted string 
		
		for (int i = 0; i < encryptedText.length(); i++) {
			
			int currentChar = (int)encryptedText.charAt(i);
			int charDecrypt = currentChar - key;		//decrytion happens here
			
			while (charDecrypt < (int)LOWER_BOUND) {		//corrects character if its out of range
				charDecrypt += RANGE;
			}
			
			decryptedCaesar += (char)charDecrypt; 
		}
		
		return decryptedCaesar; 
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptedBellaso = "";		//Holds decrypted string;
		
		for (int i = 0; i < encryptedText.length(); i++) {
			
			int currentChar = (int)encryptedText.charAt(i);
			int currentKeyChar = (int)bellasoStr.charAt(i%bellasoStr.length());
			
			int charDecrypt = currentChar - currentKeyChar;		//decryption of char happens here
			
			while (charDecrypt < (int)LOWER_BOUND) {		//corrects character if its out of range
				charDecrypt += RANGE;
			}
			
			decryptedBellaso += (char)charDecrypt;
		}
		
		return decryptedBellaso;
	}
}