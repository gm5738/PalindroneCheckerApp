/**
 * ============================================================
 * MAIN CLASS – UseCase11PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * Demonstrates Encapsulation and Single Responsibility Principle
 * by separating palindrome logic into a dedicated service class.
 *
 * Version 11.0
 */

public class usecase11 {

    public static void main(String[] args) {

        String input = "Madam";

        // Create service object
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }
    }
}


/**
 * ============================================================
 * SERVICE CLASS – PalindromeChecker
 * ============================================================
 *
 * Responsibility:
 * Contains all palindrome validation logic.
 *
 * Follows:
 * - Encapsulation
 * - Single Responsibility Principle
 */

class PalindromeChecker {

    // Public method exposed to other classes
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize input
        String processed = preprocess(input);

        // Apply two-pointer logic
        return isPalindrome(processed);
    }

    // Private method (hidden internal logic)
    private String preprocess(String str) {
        return str.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // Private method for palindrome logic
    private boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}