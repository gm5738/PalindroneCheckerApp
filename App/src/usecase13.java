import java.util.*;

public class usecase13 {

    // ==========================
    // MAIN METHOD
    // ==========================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string to test performance:");
        String input = scanner.nextLine();

        // Normalize once
        String processed = input.toLowerCase().replaceAll("[^a-z0-9]", "");

        System.out.println("\nRunning Performance Comparison...\n");

        runStack(processed);
        runDeque(processed);
        runTwoPointer(processed);
        runRecursive(processed);

        scanner.close();
    }

    // ==========================
    // STACK APPROACH
    // ==========================
    private static void runStack(String input) {

        long start = System.nanoTime();

        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        long end = System.nanoTime();

        System.out.println("Stack Approach:");
        printResult(isPalindrome, start, end);
    }

    // ==========================
    // DEQUE APPROACH
    // ==========================
    private static void runDeque(String input) {

        long start = System.nanoTime();

        Deque<Character> deque = new LinkedList<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        long end = System.nanoTime();

        System.out.println("\nDeque Approach:");
        printResult(isPalindrome, start, end);
    }

    // ==========================
    // TWO POINTER APPROACH
    // ==========================
    private static void runTwoPointer(String input) {

        long start = System.nanoTime();

        int left = 0;
        int right = input.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        long end = System.nanoTime();

        System.out.println("\nTwo Pointer Approach:");
        printResult(isPalindrome, start, end);
    }

    // ==========================
    // RECURSIVE APPROACH
    // ==========================
    private static void runRecursive(String input) {

        long start = System.nanoTime();

        boolean isPalindrome = recursiveCheck(input, 0, input.length() - 1);

        long end = System.nanoTime();

        System.out.println("\nRecursive Approach:");
        printResult(isPalindrome, start, end);
    }

    private static boolean recursiveCheck(String str, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        return recursiveCheck(str, left + 1, right - 1);
    }

    // ==========================
    // RESULT DISPLAY
    // ==========================
    private static void printResult(boolean result, long start, long end) {

        System.out.println("Result: " + (result ? "Palindrome ✅" : "Not Palindrome ❌"));
        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}