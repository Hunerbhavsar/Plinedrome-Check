import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

/**

==========================================================
MAIN CLASS – UseCase12PalindromeCheckerApp
==========================================================

Use Case 12: Strategy Pattern for Palindrome Algorithms

Description:
Demonstrates the Strategy design pattern by defining
a PalindromeStrategy interface and implementing
multiple palindrome checking algorithms.

Strategies:
- StackStrategy (uses Stack)
- DequeStrategy (uses Deque)

Allows injecting and switching strategies at runtime.

@author Developer
@version 12.0
*/

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based palindrome strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
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
}

// Deque-based palindrome strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
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
}

// Context class that uses a strategy
class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.isPalindrome(input);
    }
}

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Normalize input (optional, for fair comparison)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        System.out.println("Choose strategy: 1 for Stack, 2 for Deque");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else if (choice == 2) {
            strategy = new DequeStrategy();
        } else {
            System.out.println("Invalid choice. Using StackStrategy by default.");
            strategy = new StackStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.checkPalindrome(normalized);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
