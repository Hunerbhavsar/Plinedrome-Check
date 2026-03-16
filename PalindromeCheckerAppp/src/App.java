import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Scanner;

/**

==========================================================
MAIN CLASS – UseCase13PalindromeCheckerApp
==========================================================

Use Case 13: Performance Comparison

Description:
This class runs multiple palindrome algorithms,
measures execution time using System.nanoTime(),
and displays the performance results.

@author Developer
@version 13.0
*/

public class UseCase13PalindromeCheckerApp {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return input.equals(reversed.toString());
    }

    // Deque-based palindrome check
    public static boolean dequePalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    // Two-pointer palindrome check (char array)
    public static boolean twoPointerPalindrome(String input) {
        char[] chars = input.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input (optional for fair comparison)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Measure stack-based palindrome
        long startTime = System.nanoTime();
        boolean stackResult = stackPalindrome(normalized);
        long stackDuration = System.nanoTime() - startTime;

        // Measure deque-based palindrome
        startTime = System.nanoTime();
        boolean dequeResult = dequePalindrome(normalized);
        long dequeDuration = System.nanoTime() - startTime;

        // Measure two-pointer palindrome
        startTime = System.nanoTime();
        boolean twoPointerResult = twoPointerPalindrome(normalized);
        long twoPointerDuration = System.nanoTime() - startTime;

        // Print results
        System.out.println("\nPalindrome Check Results:");
        System.out.println("Stack method result: " + stackResult + " | Time (ns): " + stackDuration);
        System.out.println("Deque method result: " + dequeResult + " | Time (ns): " + dequeDuration);
        System.out.println("Two-pointer method result: " + twoPointerResult + " | Time (ns): " + twoPointerDuration);

        scanner.close();
    }
}
