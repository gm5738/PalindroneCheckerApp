import java.util.Deque;
import java.util.LinkedList;

/**
 * ============================================================
 * MAIN CLASS – UseCase7PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 7: Deque Based Optimized Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Deque
 * (Double Ended Queue) which allows insertion and
 * deletion from both front and rear.
 *
 * Flow:
 * - Insert characters into deque
 * - Remove first and last elements
 * - Compare until deque becomes empty or size = 1
 *
 * Version 7.0
 */

public class usecase7 {

    public static void main(String[] args) {

        // Declare and initialize input string
        String input = "racecar";   // You can change this value
        input = input.toLowerCase();

        // Create Deque
        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque (rear insertion)
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Compare front and rear elements
        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear  = deque.removeLast();

            if (front != rear) {
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