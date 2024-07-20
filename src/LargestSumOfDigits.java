import java.util.Scanner;

public class LargestSumOfDigits {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a list of words separated by spaces. Eg; 'dh7js4jf', 'or2rjvn2w', 'h1n36mfl', 'a7e6fw'");
        String input = scanner.nextLine();

        // Split the input string into an array of words
        String[] wordsArray = input.split("\\s+");

        //Validate the business logic
        ValidateTheInputs(wordsArray);

        // Testing the function with different input arrays
        System.out.println("Largest sum of digits (input): " + getLargestSumOfDigits(wordsArray));
    }

    private static void ValidateTheInputs(String[] wordsArray) {

        if (wordsArray.length > 10) {
            throw new IllegalArgumentException("Maximum number of words allowed is 10");
        }

        for (String str : wordsArray) {
            if(str.length() > 12){
                throw new IllegalArgumentException("length of each word needs to be less than 12");
            }
        }

    }

    // This function returns the largest sum
    public static int getLargestSumOfDigits(String[] arr) {

        int maxSum = 0; // Variable to store the maximum sum of digits

        for (String str : arr) {
            // Calculate the sum of digits in the current string
            int sum = sumOfDigitsInWord(str);
            // Update the maximum sum if the current sum is greater
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    // Function to calculate the sum of each word
    public static int sumOfDigitsInWord(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            // Check if the character is a digit
            if (Character.isDigit(ch)) {
                // Convert the character to its integer value and add to the sum
                sum += Character.getNumericValue(ch);
            }
        }
        return sum;
    }
}