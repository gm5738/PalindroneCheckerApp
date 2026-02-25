import java.util.Stack;

/**
 * ============================================================
 * MAIN CLASS – UseCase5PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 5: Stack Based Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Stack
 * data structure which follows the LIFO principle.
 *
 * Flow:
 * - Push characters into stack
 * - Pop characters in reverse order
 * - Compare with original sequence
 * - Display result
 *
 * Version 5.0
 */

public class usecase5 {

    /**
     * Application entry point for UC5.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Declare and initialize input string
        String input = "noon";   // You can change this value

        // Convert to lowercase (optional: for case-insensitive check)
        input = input.toLowerCase();

        // Create a Stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character into the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Assume it is palindrome initially
        boolean isPalindrome = true;

        // Compare original string with reversed (stack pop)
        for (char c : input.toCharArray()) {
            char poppedChar = stack.pop();
            if (c != poppedChar) {
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