package com.solodkyi.java_labs.Lab4_2Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.solodkyi.java_labs.Lab4_2.*;
public class DecoderTest {

    private String wordForDecodeByVowels = "t2st3ng";
    private String wordForDecodeByConsonants = "uftujoh";

    private String wordForEncode = "testing";


    @Test
    void testEncodingByVowels() {
        assertEquals("t2st3ng", Decoder.encodeVowels(wordForEncode));
    }


    @Test
    void testEncodingByConsonants() {
        assertEquals("uftujoh", Decoder.encodeConsonants(wordForEncode));
    }


    @Test
    void testDecodingByVowels() {
        assertEquals("testing", Decoder.decodeVowels(wordForDecodeByVowels));
    }

    @Test
    void testDecodingByConsonants() {
        assertEquals("testing", Decoder.decodeConsonants(wordForDecodeByConsonants));
    }

}