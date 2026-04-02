package workshop5;

import java.util.Scanner;

public class RestaurantSignup {

    // Arrays to store signed-up users (max 100 users)
    static String[] names = new String[100];
    static String[] mobiles = new String[100];
    static String[] passwords = new String[100];
    static String[] dobs = new String[100];
    static int userCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        // Keep running until user selects Quit
        do {
            System.out.println("\nPlease enter 1 for Sign up.");
            System.out.println("Please enter 2 for Quit.");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear leftover newline

            if (choice == 1) {
                signUp(sc);
            } else if (choice == 2) {
                System.out.println("\nThank you for using the Application.");
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 2);

        sc.close();
    }

    // -------------------------------------------------------
    // Sign-up method
    // -------------------------------------------------------
    static void signUp(Scanner sc) {
        boolean signupDone = false;

        while (!signupDone) {
            boolean allValid = true;

            // --- Full Name ---
            System.out.print("\nPlease enter your full name: ");
            String name = sc.nextLine();
            if (name.length() <= 4) {
                System.out.println("Full name must be greater than 4 characters.");
                System.out.println("Please start again.");
                allValid = false;
                continue;
            }

            // --- Mobile Number ---
            System.out.print("Please enter your mobile number (username): ");
            String mobile = sc.nextLine();
            if (!isValidMobile(mobile)) {
                System.out.println("Mobile number must be 10 digits and start with 0.");
                System.out.println("Please start again.");
                allValid = false;
                continue;
            }

            // --- Password ---
            System.out.print("Please enter your password: ");
            String password = sc.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("Password must start with letters, contain @ or & in the middle, and end with numbers.");
                System.out.println("Example: John@0125 or John&25");
                System.out.println("Please start again.");
                allValid = false;
                continue;
            }

            // --- Confirm Password ---
            System.out.print("Please confirm your password: ");
            String confirmPassword = sc.nextLine();
            if (!password.equals(confirmPassword)) {
                System.out.println("Your passwords are not matching.");
                System.out.println("Please start again.");
                allValid = false;
                continue;
            }

            // --- Date of Birth ---
            System.out.print("Please enter your Date of Birth #DD/MM/YYYY (No space): ");
            String dob = sc.nextLine();
            if (!isValidDOB(dob)) {
                System.out.println("You have entered the Date of Birth in invalid format.");
                System.out.println("Please use DD/MM/YYYY or MM/DD/YYYY format.");
                System.out.println("Please start again.");
                allValid = false;
                continue;
            }

            // --- Age check (at least 21 based on year) ---
            int birthYear = getBirthYear(dob);
            int currentYear = 2026;
            int age = currentYear - birthYear;
            if (age < 21) {
                System.out.println("You must be at least 21 years old to sign up.");
                System.out.println("Please start again.");
                allValid = false;
                continue;
            }

            // --- All valid: save user ---
            if (allValid) {
                names[userCount] = name;
                mobiles[userCount] = mobile;
                passwords[userCount] = password;
                dobs[userCount] = dob;
                userCount++;

                System.out.println("\nYou have successfully signed up.");
                signupDone = true;
            }
        }
    }

    // -------------------------------------------------------
    // Validation: Mobile must be 10 digits starting with 0
    // -------------------------------------------------------
    static boolean isValidMobile(String mobile) {
        return mobile.matches("0\\d{9}"); // starts with 0, followed by 9 digits
    }

    // -------------------------------------------------------
    // Validation: Password - letters + (@ or &) + digits
    // Example: John@0125 or John&25
    // -------------------------------------------------------
    static boolean isValidPassword(String password) {
        return password.matches("[a-zA-Z]+[@&]\\d+");
    }

    // -------------------------------------------------------
    // Validation: DOB must be DD/MM/YYYY or MM/DD/YYYY
    // -------------------------------------------------------
    static boolean isValidDOB(String dob) {
        return dob.matches("\\d{2}/\\d{2}/\\d{4}");
    }

    // -------------------------------------------------------
    // Extract birth year from DOB string (last 4 chars)
    // -------------------------------------------------------
    static int getBirthYear(String dob) {
        String yearStr = dob.substring(6); // YYYY is always at the end
        return Integer.parseInt(yearStr);
    }
}
