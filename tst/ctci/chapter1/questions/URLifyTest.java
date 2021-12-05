package ctci.chapter1.questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLifyTest {

    URLify urLify = new URLify();

    @Test
    void urlify_emptyString() {
        char[] inputString = new char[]{};
        char[] expectedString = new char[]{};

        urLify.urlify(inputString, 0);
        assertArrayEquals(expectedString, inputString);
    }

    @Test
    void urlify_spacesOnly() {
        char[] inputString = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};
        char[] expectedString = new char[]{'%','2','0','%','2','0','%','2','0'};

        urLify.urlify(inputString, 3);
        assertArrayEquals(expectedString, inputString);
    }

    @Test
    void urlify_spacesAndCharacters() {
        char[] inputString = new char[]{'M','r',' ','J','o','h','n',' ','S','M','I','T','H',' ',' ',' ',' '};
        char[] expectedString = new char[]{'M','r','%','2','0','J','o','h','n','%','2','0','S','M','I','T','H'};

        urLify.urlify(inputString, 13);
        assertArrayEquals(expectedString, inputString);
    }
}