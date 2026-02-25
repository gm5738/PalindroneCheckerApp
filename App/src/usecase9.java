/**
 * ============================================================
 * MAIN CLASS – UseCase9PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 9: Recursive Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using recursion.
 *
 * Flow:
 * - Recursive method compares start and end characters
 * - Base condition stops recursion
 * - Returns true if all pairs match
 *
 * Version 9.0
 */

public class usecase9 {

    public static void main(String[] args) {

        String input = "radar";   // Change value if needed
        input = input.toLowerCase();

        boolean isPalindrome = checkPalindrome(input, 0, input.length() - 1);

        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }
    }

    // Recursive method
    public static boolean checkPalindrome(String str, int start, int end) {

        // Base condition: If start crosses end, it's palindrome
        if (start >= end) {
            return true;
        }

        // If characters don't match, not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call: Move towards center
        return checkPalindrome(str, start + 1, end - 1);
    }
}