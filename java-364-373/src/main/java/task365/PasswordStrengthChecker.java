package task365;

import java.util.Scanner;

public class PasswordStrengthChecker {
    //initialize scanner
    Scanner in = new Scanner(System.in);

    //declare required variables
    String password, strengthLevel;
    int choice, upperCaseCount, lowerCaseCount, digitCount, specialCharCount, conditionMetCount;
    boolean hasUpperCase, hasLowerCase, hasNumbers, hasSpecialChar, properPasswordLength;

    //main function
    void main() {
        //Prompt the user to enter a password
        System.out.print("Enter the password: ");
        password = in.next().strip();

        if (password.length() <= 0) { //invalid password
            System.out.println("Invalid password.");
        } else { //valid password
            //menu
            choice = 0;
            while (choice != 7) {
                //print menu
                System.out.println("\n===== MENU =====");
                System.out.println("1. Enter Password");
                System.out.println("2. Check Password Length");
                System.out.println("3. Analyze Password Characters");
                System.out.println("4. Check Password Strength");
                System.out.println("5. Convert Password Format");
                System.out.println("6. Display Password Report");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");
                choice = in.nextInt();

                switch (choice) {

                    //add student
                    case 1:
                        enterPassword();
                        break;

                    //search student
                    case 2:
                        checkPasswordLength();
                        break;

                    //update attendance
                    case 3:
                        analyzePasswordCharacters();
                        break;

                    //remove student
                    case 4:
                        checkPasswordStrength();
                        break;

                    //display all records
                    case 5:
                        convertPasswordFormat();
                        break;

                    //display statistics
                    case 6:
                        displayPasswordReport();
                        break;

                    //exit
                    case 7:
                        System.out.println("GoodBye~");
                        break;

                    //invalid choice
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

        //close scanner
        in.close();
    }

    public void enterPassword() {
        //Prompt the user to enter a password
        System.out.print("\nEnter Password -----\nEnter the password: ");
        password = in.next().strip(); //remove extra spaces
        System.out.println("Password saved successfully.");
    }

    public void checkPasswordLength() {
        System.out.println("\nCheck Password Length -----");
        System.out.println("Total number of characters in the password: " + password.length());

        //check length and print appropriate msg
        if (password.length() < 8) System.out.println("Password is too short.");
        else {
            System.out.println("Password length is acceptable.");
        }
    }

    public void analyzePasswordCharacters() {
        System.out.println("\nAnalyze Password Characters -----");
        //set start value
        upperCaseCount = 0;
        lowerCaseCount = 0;
        digitCount = 0;
        specialCharCount = 0;

        //Use a loop and if statements to count
        for (char p : password.toCharArray()) {
            if (Character.isAlphabetic(p)) { //alphabetic
                if (Character.isLowerCase(p)) lowerCaseCount++;
                else upperCaseCount++;
            } else if (Character.isDigit(p)) { //numbers
                digitCount++;
            } else { //special characters
                specialCharCount++;
            }
        }

        //display results
        System.out.println("Uppercase letters: " + upperCaseCount);
        System.out.println("Lowercase  letters: " + lowerCaseCount);
        System.out.println("Digits: " + digitCount);
        System.out.println("Special characters: " + specialCharCount);
    }

    public void checkPasswordStrength() {
        System.out.println("\nCheck Password Strength -----");
        //set start values
        hasUpperCase = hasLowerCase = hasSpecialChar = hasNumbers = properPasswordLength = false;
        //Use a loop to check strength
        for (char p : password.toCharArray()) {
            if (Character.isAlphabetic(p)) { //alphabetic
                if (Character.isUpperCase(p)) hasUpperCase = true;
                else hasLowerCase = true;
            } else if (Character.isDigit(p)) { //numbers
                hasNumbers = true;
            } else { //special characters
                hasSpecialChar = true;
            }
        }
        if (password.length() >= 8) properPasswordLength = true;

        //count number of conditions met
        conditionMetCount = 0;
        if (hasUpperCase) {
            System.out.println("Password has upper case letter/s");
            conditionMetCount++;
        }
        if (hasLowerCase) {
            System.out.println("Password has lower case letter/s");
            conditionMetCount++;
        }
        if (hasNumbers) {
            System.out.println("Password has number/s");
            conditionMetCount++;
        }
        if (hasSpecialChar) {
            System.out.println("Password has special character/s");
            conditionMetCount++;
        }
        if (properPasswordLength) {
            System.out.println("Password has proper length (at least 8 characters)");
            conditionMetCount++;
        }

        //print final result
        if (conditionMetCount>=4) strengthLevel="Strong Password";

        else if (conditionMetCount>=2) strengthLevel="Medium Password";

        else strengthLevel="Weak Password";

        System.out.println("===> "+strengthLevel);
    }

    public void convertPasswordFormat() {
        System.out.println("\nConvert Password Format -----");
        System.out.println("Password in uppercase: "+password.toUpperCase());
        System.out.println("Password in lowercase: "+password.toLowerCase());
    }

    public void displayPasswordReport() {
        analyzePasswordCharacters();
        checkPasswordStrength();
        System.out.println("\nDisplay Password Report -----");
        System.out.println("Password length: "+ password.length());
        System.out.println("First character: "+password.toCharArray()[0]);
        System.out.println("Last character: "+password.toCharArray()[password.length()-1]);
        System.out.println("Number of uppercase letters: "+upperCaseCount);
        System.out.println("Number of lowercase letters: "+lowerCaseCount);
        System.out.println("Number of digits: "+digitCount);
        System.out.println("Number of special characters: "+specialCharCount);
        System.out.println("Password strength level: "+strengthLevel);
    }
}
