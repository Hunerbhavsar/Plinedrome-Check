import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

/**

==========================================================
MAIN CLASS – UseCase7PalindromeCheckerApp
==========================================================

Use Case 7: Deque-Based Optimized Palindrome Checker

Description:
This class validates a palindrome using a Deque
(Double Ended Queue). Characters are inserted
into the deque and compared from both ends.

At this stage, the application:
Inserts characters into a deque
Removes characters from front and rear
Compares them until the deque becomes empty
Displays the result

@author Developer
@version 7.0
*/

public class UseCase7PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Deque<Character> deque = new ArrayDeque<>();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Insert characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front and rear elements
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
