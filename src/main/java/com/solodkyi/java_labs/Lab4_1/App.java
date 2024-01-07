package com.solodkyi.java_labs.Lab4_1;

public class App {

    public static boolean IsPalindrome(String word) {
        if(word.isEmpty()) return true;

        int first = 0;
        int last = word.length() - 1;

        while (first <= last)
        {
            char currentFirst = word.charAt(first);
            char currentLast = word.charAt(last);

            if(currentFirst == ' ') {
                first++;
            }
            else if(currentLast == ' ') {
                last--;
            }
            else {
                if(Character.toLowerCase(currentFirst) != Character.toLowerCase(currentLast)) return false;
                first++;
                last--;
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(IsPalindrome("Rotator"));
        System.out.println(IsPalindrome("clsd"));
        System.out.println(IsPalindrome("SOS"));
        System.out.println(IsPalindrome("Malayalam"));
    }

}