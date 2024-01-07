package com.solodkyi.java_labs.Lab4_2;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class App {
    public static void main(String[] args) {
        String encryptedMessage = "Fodpef boe efdpef tusjoht jt gvo";
        System.out.println(encryptedMessage);
        decodeMessage(encryptedMessage);


        System.out.println();
        
        System.out.println("Encoded word by vowels: java virtual mashine - " + Decoder.encodeVowels("java virtual mashine"));
        System.out.println("Encoded word by consonants: java virtual mashine - " + Decoder.encodeConsonants("Encode and decode strings is fun"));
        
    }

    static void decodeMessage(String encryptedMessage) {
        String[] words = encryptedMessage.split(" ");

        for (int i = 0; i < words.length; i++) {
            Pattern pattern = Pattern.compile(".*\\d.*"); 
            Matcher matcher = pattern.matcher(words[i]);
    
            if (matcher.matches()) {
                System.out.println("Decoded word " + (i+1) + ": " + words[i] + " is " + Decoder.decodeVowels(words[i])); 
            } else {
                System.out.println("Decoded word " + (i+1) + ": " + words[i] + " is " + Decoder.decodeConsonants(words[i]));
            }
        }
    }
}