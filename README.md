# Email Validator

This is a simple Java application that validates email addresses based on custom criteria. The program uses regular expressions and additional logic to ensure that the email contains the required special characters in the correct positions.

## Features

- **User Input:** Reads an email address from the console.
- **Preliminary Check:** Uses a regular expression to detect if the email contains any special characters (i.e., characters other than letters and digits).
- **Validation Logic:** 
  - Ensures the email contains exactly one `@` symbol.
  - Checks that there is at least one, and at most four, `.` (dot) characters following the `@` symbol.
- **Feedback:** Prints a message to the console indicating whether the email is valid or not.

## How It Works

1. **User Input:**  
   The program prompts the user to enter an email address using a `Scanner` wrapped in a try-with-resources statement (which ensures the resource is automatically closed).

2. **Preliminary Validation:**  
   A regex (`[^a-zA-Z0-9]`) is used to confirm that the email contains special characters. If none are found, the email is immediately deemed invalid.

3. **Detailed Validation:**  
   - The code iterates through the email string to count the occurrences of the `@` symbol and remembers its position.
   - It then checks that there is exactly one `@`.
   - Starting from the position right after `@`, it counts how many `.` characters are present. If the count is between 1 and 4 (inclusive), the email is considered valid.

4. **Output:**  
   The application outputs whether the entered email is valid based on the above criteria.

## Prerequisites

- **Java Development Kit (JDK):** Make sure you have JDK 8 or higher installed on your machine.
- **Command Line or IDE:** Familiarity with compiling and running Java programs via the command line or an IDE.

## How to Run

1. **Clone or Download the Repository:**

   ```bash
   git clone https://github.com/yourusername/email-validator.git
   cd email-validator

2. **Compile the Code:

   ```bash
   javac Main.java

3. **Run the Application:

   ```bash
   java Main

4. **Follow the Prompt:

The program will prompt you to type your email. Enter an email address and press Enter to see if it is considered valid.


## Future Improvements
   **Robust Regex Validation:**
    - Instead of using a preliminary regex that only checks for any non-alphanumeric character, consider using a comprehensive regex pattern to validate the full structure of an email address.

   **Enhanced Logic:**
    - The current logic imposes a strict rule on the number of . characters after the @ symbol. Future iterations could allow for more flexible validation rules to accommodate a wider range of valid email formats.

   **Separation of Concerns:**
    - Consider separating the validation logic from the user interface, allowing for easier unit testing and maintenance.

## License
  - This project is licensed under the MIT License. See the LICENSE file for details.
