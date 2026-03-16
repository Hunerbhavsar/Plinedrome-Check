import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

/**
 * ============================================================
 * MAIN CLASS – UseCase6PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 6: Queue + Stack Fairness Check
 *
 * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 *
 * - Queue (FIFO - First In First Out)
 * - Stack (LIFO - Last In First Out)
 *
 * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 *
 * If all characters match, the input string is confirmed
 * as a palindrome.
 *
 * @author Developer
 * @version 6.0
 */

public class UseCase6PalindromeCheckerApp {

    /**
     * Application entry point for UC6.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Insert characters into Queue and Stack
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            queue.add(ch);      // Enqueue
            stack.push(ch);     // Push
        }

        boolean isPalindrome = true;

        // Compare dequeue (queue) vs pop (stack)
        while (!queue.isEmpty()) {
            char qChar = queue.remove();  // Dequeue
            char sChar = stack.pop();     // Pop

            if (qChar != sChar) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
