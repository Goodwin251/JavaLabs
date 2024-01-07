package com.solodkyi.java_labs.Lab4_2;

public class Decoder {
	private static final String CONSONANTS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
    public static String decodeVowels(String input) {
        StringBuilder decoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '1':
                    decoded.append('a');
                    break;
                case '2':
                    decoded.append('e');
                    break;
                case '3':
                    decoded.append('i');
                    break;
                case '4':
                    decoded.append('o');
                    break;
                case '5':
                    decoded.append('u');
                    break;
                default:
                    decoded.append(c);
            }
        }
        return decoded.toString();
    }

    public static String encodeVowels(String input) {
        StringBuilder encoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'a':
                    encoded.append('1');
                    break;
                case 'e':
                    encoded.append('2');
                    break;
                case 'i':
                    encoded.append('3');
                    break;
                case 'o':
                    encoded.append('4');
                    break;
                case 'u':
                    encoded.append('5');
                    break;
                default:
                    encoded.append(c);
            }
        }
        return encoded.toString();
    }

    public static String encodeConsonants(String input) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
           
            char nextConsonant = getNext(c);
            encoded.append(nextConsonant);
        }
        return encoded.toString();
    }

    public static String decodeConsonants(String input) {
        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            char nextConsonant = getPrevious(c);
            decoded.append(nextConsonant);
        }
        return decoded.toString();
    }

    private static char getNext(char c) {
        String consonants = CONSONANTS;
        int index = consonants.indexOf(c);
        if (index != -1 && index < consonants.length() - 1) {
            return consonants.charAt(index + 1);
        }
        return c;
    }
    private static char getPrevious(char c) {
        String consonants = CONSONANTS;
        int index = consonants.indexOf(c);
        if (index != 0 && index <= consonants.length()) {
            return consonants.charAt(index - 1);
        }
        return c;
    }
}
