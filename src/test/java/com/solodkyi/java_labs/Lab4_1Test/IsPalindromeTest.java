package com.solodkyi.java_labs.Lab4_1Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.solodkyi.java_labs.Lab4_1.*;

public class IsPalindromeTest {
    @Test
    void testPalindromes() {
    	assertTrue(App.IsPalindrome(""));
        assertTrue(App.IsPalindrome("Level"));
        assertTrue(App.IsPalindrome("Noon"));
        assertTrue(App.IsPalindrome("  "));
    }
    @Test 
    void testIsNotPalindromes() {
    	assertFalse(App.IsPalindrome("math"));
        assertFalse(App.IsPalindrome("Hi, how are you?"));
    }
}
