package ctci.chapter1.questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

    Permutations permutations = new Permutations();

    @Test
    void isPermutation_happyCase() {
        assertTrue(permutations.isPermutation("test", "sett"));
    }

    @Test
    void isPermutation_misMatchedCases() {
        assertFalse(permutations.isPermutation("test","seTt"));
    }

    @Test
    void isPermutation_mismatchedWhitespace() {
        assertFalse(permutations.isPermutation("test", " sett"));
    }

    @Test
    void isPermutation_mismatchedLength() {
        assertFalse(permutations.isPermutation("test", "testing"));
    }

    @Test
    void isPermutation_mismatchedCharacters() {
        assertFalse(permutations.isPermutation("test", "tist"));
    }

    @Test
    void isPermutation_emptyStrings() {
        assertTrue(permutations.isPermutation(" ", " "));
    }
}