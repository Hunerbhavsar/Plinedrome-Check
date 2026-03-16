import java.util.Scanner;
import java.util.Stack;

/**

==========================================================
MAIN CLASS – UseCase11PalindromeCheckerApp
==========================================================

Use Case 11: Object-Oriented Palindrome Service

Description:
This class demonstrates palindrome validation using
Object-Oriented principles. The palindrome logic is
encapsulated inside a service class called
PalindromeChecker.

Concepts Used:
- Encapsulation
- Single Responsibility Principle

@author Developer
@version 11.0
*/

// Service class that handles palindrome checking
class PalindromeChecker {

    // Method to check palindrome
    public boolean checkPalindrome(String input) {

        Stack<Character> stack = new Stack<>();

        // Push characters to stack
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        // Build reversed string using stack
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        // Compare original and reversed
        return input.equals(reversed);
    }
}

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create service object
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}
