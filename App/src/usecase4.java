public class usecase4 {
    public static void main(String[] args) {


    String word = "radar";   // Hardcoded string

    // Convert string to character array
    char[] characters = word.toCharArray();

    int start = 0;
    int end = characters.length - 1;
    boolean isPalindrome = true;

    // Two-pointer comparison
    while (start < end) {
        if (characters[start] != characters[end]) {
            isPalindrome = false;
            break;
        }
        start++;
        end--;
    }

    // Display result
    if (isPalindrome) {
        System.out.println(word + " is a Palindrome");
    } else {
        System.out.println(word + " is NOT a Palindrome");
    }
}
}
