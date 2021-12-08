package ctci.chapter1.questions;

/**
 * 1.3
 *
 * Write a method to replace al spaces in a string with '%20'. Assume sufficient space and perform the method in place.
 */
public class URLify {

    /**
     * Performs the replacement in place, working backwords from the end of the string.
     *
     * @param inputStr
     * @param trueLength
     * @return the string, where each space is replaced with '%20'.
     */
    public void urlify(char[] inputStr, int trueLength) {
        if (inputStr.length < 1) {
            return;
        }

        int j = inputStr.length - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (inputStr[i] == ' ') {
                inputStr[j] = '0';
                j--;
                inputStr[j] = '2';
                j--;
                inputStr[j] = '%';
                j--;
            } else {
                inputStr[j] = inputStr[i];
                j--;
            }
        }
    }
}
