package ctci.chapter1.questions;

/**
 * 1.1
 *
 * Implement an algorithm to determine if a string has all unique characters.
 *
 * What if you cannot use additional data structures?
 */
public class IsUnique {

    /**
     * Implements isUnique by maintaining a boolean array the size of the character set. When a caracter is seen,
     * mark it's corresponding index as true. Upon seeing a conflict, return false.
     *
     * @param inputStr
     * @return false if the string is not entirely unique, true otherwise.
     */
    public boolean isUnique(String inputStr) {

        // Assume a-z in the english alphabet as the available character set.
        boolean[] hasSeen = new boolean[26];

        // Immediately return false if input length is longer than available character set.
        if (inputStr.length() > hasSeen.length) {
            return false;
        }

        for(int i = 0; i < inputStr.length(); i++) {
            int index = inputStr.charAt(i) % 26;

            if (hasSeen[index]) {
                return false;
            }

            hasSeen[index] = true;
        }

        return true;
    }

    /**
     * todo: What if you cannot use additional data structures?
     * @return false if the string is not entirely unique, true otherwise.
     */
    public boolean isUniqueWithoutAdditional() {
        throw new RuntimeException("Not yet implemented!");
    }
}
