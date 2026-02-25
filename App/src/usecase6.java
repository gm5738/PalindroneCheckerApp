import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 * ============================================================
 * MAIN CLASS – UseCase6PalindromeCheckerApp
 * ============================================================
 *
 * Use Case 6: Queue + Stack Based Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using both:
 * - Stack (LIFO)
 * - Queue (FIFO)
 *
 * Flow:
 * - Enqueue characters into queue (FIFO)
 * - Push characters into stack (LIFO)
 * - Compare dequeue vs pop
 * - Display result
 *
 * Version 6.0
 */

public class usecase6{

    public static void main(String[] args) {

        // Declare and initialize input string
        String input = "madam";   // You can change this value
        input = input.toLowerCase();

        // Create Stack (LIFO)
        Stack<Character> stack = new Stack<>();

        // Create Queue (FIFO)
        Queue<Character> queue = new LinkedList<>();

        // Insert characters into both structures
        for (char c : input.toCharArray()) {
            stack.push(c);      // LIFO
            queue.add(c);       // FIFO (enqueue)
        }

        // Assume palindrome initially
        boolean isPalindrome = true;

        // Compare pop (stack) with remove (queue)
        while (!stack.isEmpty()) {

            char fromStack = stack.pop();      // LIFO
            char fromQueue = queue.remove();   // FIFO (dequeue)

            if (fromStack != fromQueue) {
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