/**
 * ============================================================
 * MAIN CLASS – UseCase10PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 10: Case-Insensitive & Space-Ignored Palindrome
 *
 * Description:
 * This class validates a palindrome by:
 * - Normalizing the string (remove spaces/special characters)
 * - Converting to lowercase
 * - Applying two-pointer comparison logic
 *
 * Version 10.0
 */

public class usecase10 {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";   // Change value if needed

        // Step 1: Normalize string
        String normalized = preprocess(input);

        // Step 2: Apply palindrome check
        boolean isPalindrome = checkPalindrome(normalized);

        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome.");
        }
    }

    // Method to preprocess string
    public static String preprocess(String str) {

        // Convert to lowercase
        str = str.toLowerCase();

        // Remove all non-alphanumeric characters (spaces, punctuation, etc.)
        str = str.replaceAll("[^a-z0-9]", "");

        return str;
    }

    // Two-pointer palindrome check
    public static boolean checkPalindrome(String str) {

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