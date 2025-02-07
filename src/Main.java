import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String email;  // Variable to store the email entered by the user

        // Using try-with-resources to automatically close the Scanner when done
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("type here your email: ");
            // Read the entire line entered by the user
            email = scanner.nextLine();

            // Call the isValid method to check if the email meets our validation criteria.
            if (isValid(email)) {
                System.out.println("This is a valid email");
            } else {
                System.out.println("This is not a valid email");
            }

        } catch (Exception e) {
            // In case any exception occurs, print the stack trace for debugging
            e.printStackTrace();
        }
    }

    // This method checks if the given email is valid based on certain criteria.
    private static boolean isValid(String email) {

        // Define a regex that matches any character that is NOT a letter or digit.
        // This check is used as a preliminary filter to ensure there are special characters.
        String regex = "[^a-zA-Z0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        // If the email contains any special character, proceed with further validation.
        if (matcher.find()) {
            int counter = 0;   // Counter for the number of '@' characters found
            int position = 0;  // Variable to store the position (index) of the '@' character

            // Loop through each character of the email to count '@' occurrences
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    counter++;      // Increment counter for each '@' found
                    position = i;   // Save the index position of '@'
                }
            }

            // Check that exactly one '@' character exists in the email
            if (counter == 1) {
                counter = 0; // Reset counter to use it for counting '.' characters

                // Loop through the substring that comes after the '@' character
                for (int i = position + 1; i < email.length(); i++) {
                    if (email.charAt(i) == '.') {
                        counter++;  // Increment counter for each '.' found after '@'
                    }
                }
                // If there's at least one '.' and at most four '.' characters after '@', consider it valid.
                return counter > 0 && counter <= 4;
            } else {
                // If there isn't exactly one '@', the email is invalid.
                return false;
            }
        } else {
            // If the email doesn't contain any special characters, it's invalid.
            return false;
        }
    }
}
