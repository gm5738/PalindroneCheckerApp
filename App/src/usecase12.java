import java.util.Stack;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * ============================================================
 * UseCase12PalindromeCheckerApp
 * Strategy Pattern - Single File Version
 * ============================================================
 */

public class usecase12 {

    // ==========================
    // Strategy Interface
    // ==========================
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // ==========================
    // Stack Strategy
    // ==========================
    static class StackStrategy implements PalindromeStrategy {

        @Override
        public boolean check(String input) {

            String processed = preprocess(input);

            Stack<Character> stack = new Stack<>();

            for (char c : processed.toCharArray()) {
                stack.push(c);
            }

            for (char c : processed.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // ==========================
    // Deque Strategy
    // ==========================
    static class DequeStrategy implements PalindromeStrategy {

        @Override
        public boolean check(String input) {

            String processed = preprocess(input);

            Deque<Character> deque = new LinkedList<>();

            for (char c : processed.toCharArray()) {
                deque.addLast(c);
            }

            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast())) {
                    return false;
                }
            }

            return true;
        }
    }

    // ==========================
    // Context Class
    // ==========================
    static class PalindromeContext {

        private PalindromeStrategy strategy;

        public void setStrategy(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean execute(String input) {
            if (strategy == null) {
                throw new IllegalStateException("Strategy not selected!");
            }
            return strategy.check(input);
        }
    }

    // ==========================
    // Common Preprocessing
    // ==========================
    private static String preprocess(String input) {
        return input.toLowerCase().replaceAll("[^a-z0-9]", "");
    }

    // ==========================
    // MAIN METHOD
    // ==========================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter String:");
        String input = scanner.nextLine();

        System.out.println("\nChoose Algorithm:");
        System.out.println("1 - Stack Strategy");
        System.out.println("2 - Deque Strategy");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        PalindromeContext context = new PalindromeContext();

        switch (choice) {
            case 1:
                context.setStrategy(new StackStrategy());
                break;
            case 2:
                context.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid Choice!");
                return;
        }

        boolean result = context.execute(input);

        if (result) {
            System.out.println("\nResult: Palindrome ✅");
        } else {
            System.out.println("\nResult: Not a Palindrome ❌");
        }

        scanner.close();
    }
}