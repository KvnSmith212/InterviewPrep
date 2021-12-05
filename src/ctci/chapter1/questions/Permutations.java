package ctci.chapter1.questions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 1.2
 *
 * Check Permutation: Given two strings, write a method to determine if one is a permuation of the other.
 */
public class Permutations {

    /**
     * Check for permutation by keeping count of characters within a hashmap. Assumes case and white space matter.
     *
     * @param str1
     * @param str2
     * @return true if is a permutation, false otherwise.
     */
    public boolean isPermutation(String str1, String str2) {
        // Can return early by checking the length.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Initialize charCounts with string 1.
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for(int i = 0; i < str1.length(); i++) {
            char curr = str1.charAt(i);
            if (charCounts.containsKey(curr)) {
                charCounts.put(curr, charCounts.get(curr) + 1);
            } else {
                charCounts.put(curr, 1);
            }
        }

        // Decrement against string 2.
        for(int i = 0; i < str2.length(); i++) {
            char curr = str2.charAt(i);
            if (charCounts.containsKey(curr)) {
                charCounts.put(curr, charCounts.get(curr) - 1);
            } else {
                // found a character in str2 that is not in str1
                return false;
            }
        }

        // Check the values against 0.
        ArrayList<Integer> values = new ArrayList<>(charCounts.values());
        for (Integer value : values) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}
