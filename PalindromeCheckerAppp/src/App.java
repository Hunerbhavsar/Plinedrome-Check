/**
 * ==========================================================
 * MAIN CLASS – UseCase2PalindromeCheckerApp
 * ==========================================================
 * Use Case 2: Hardcoded Palindrome Validation
 * Description:
 * This class demonstrates basic palindrome validation
 * using a hardcoded string value.
 *
 * @Huner
 * @version 2.0
 */

public class App {
    public static void main(String[] args) {

        // Hardcoded string
        String input = "madam";

        boolean isPalindrome = true;

        // Loop only till half of the string length
        for (int i = 0; i < input.length() / 2; i++) {

            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }
    }
}