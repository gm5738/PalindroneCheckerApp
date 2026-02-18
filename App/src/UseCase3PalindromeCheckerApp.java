public class UseCase3PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "level";   // Hardcoded string
        String reversed = "";

        // Reverse using for loop
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        // Compare original and reversed
        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}
