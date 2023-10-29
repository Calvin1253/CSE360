package asuHelloWorldJavaFX;
import java.util.*;

public class InputValidator {

	public Object input;
	public int returnVal; // 0 - NormalString, 1 - String with Special Characters, 2 - Integer, 3 - Double, 4 - INVALID(Unkown)
	HashMap<Character, Integer> alphabet = new HashMap<>();
	HashMap<Character, Integer> SpecialChar = new HashMap<>();

	public InputValidator(Object input) {
		this.input = input;
		returnVal = 20;
		int i = 0;
		// Create a HashMap for the alphabet containing lowercase letters (a-z)
		for (char c = 'a'; c <= 'z'; c++) {
			this.alphabet.put(c, i);
			i++;
		}
		// Add uppercase letters (A-Z) to the alphabet HashMap
		for (char c = 'A'; c <= 'Z'; c++) {
			alphabet.put(c, 1);
		}

		//For special Characters
		String special = "!@#$%^&*()";
		special.toCharArray();
		i = 0;
		// Create a HashMap for special characters
		for (char c : special.toCharArray()) {
			this.SpecialChar.put(c, i);
			i++;
		}
	}

	// Method to checkType
	public int checkType(Object input) {
		if (input instanceof String) {
			// Check if the string contains only normal alphabet characters
			if (charactersExistInAlphabet()) {
				this.returnVal = 0; // String with only normal Strings
			}
			// Check if the string contains both normal and special characters
			else if (charactersExistInAlphabetAndSpecial()) {
				this.returnVal = 1; // SpecialChar String
			}
		} else if (input instanceof Integer) {
			this.returnVal = 2;
		} else if (input instanceof Double) {
			this.returnVal = 3;
		} else {
			this.returnVal = 4; // INVALID (Unknown)
		}
		return returnVal;
	}

	// Check if all characters in the input string are in the alphabet
	public boolean charactersExistInAlphabet() {
		String inputString = (String) this.input;
		char[] inputChars = inputString.toCharArray();
		for (char c : inputChars) {
			if (!this.alphabet.containsKey(c)) {
				return false; // Character not in the alphabet
			}
		}
		return true; // All characters are in the alphabet
	}

	// Check if all characters in the input string are in either the alphabet or special characters
	public boolean charactersExistInAlphabetAndSpecial() {
		String inputString = (String) this.input;
		char[] inputChars = inputString.toCharArray();
		for (char c : inputChars) {
			if (!this.alphabet.containsKey(c) && !this.SpecialChar.containsKey(c)) {
				return false; // Character not in the alphabet or special characters
			}
		}
		return true; // All characters are in the alphabet or special characters
	}
}
