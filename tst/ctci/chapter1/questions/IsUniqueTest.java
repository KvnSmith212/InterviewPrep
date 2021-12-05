package ctci.chapter1.questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsUniqueTest {

    IsUnique isUnique = new IsUnique();

    @Test
    void isUnique_happyCase() {
        assertTrue(isUnique.isUnique("String"));
    }

    @Test
    void isUnique_emptyString() {
        assertTrue(isUnique.isUnique(""));
    }

    @Test
    void isUnique_isLargerThanCharacterSet() {
        assertFalse(isUnique.isUnique("abcdefghijklmnopqurtuvwxyzabcdefghijklmnopqurtuvwxyz"));
    }

    @Test
    void isUnique_containesDuplicates() {
        assertFalse(isUnique.isUnique("Not unique."));
    }
}