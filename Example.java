import java.util.Scanner;

public class Example {
    public static int getValidInteger(String prompt, int minValue, int maxValue) {
        int userInput;

        while (true) {
            try {
               Scanner scanner = new Scanner(System.in);
                System.out.print(prompt);
                userInput = Integer.parseInt(scanner.nextLine());

                if (userInput >= minValue && userInput <= maxValue) {
                    return userInput;
                } else {
                    System.out.println("Please enter an integer between " + minValue + " and " + maxValue + ".");
                }
                 scanner.close();
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
       
    }

    public static void main(String[] args) {
        int minValue = 1;
        int maxValue = 100;
        int userInput = getValidInteger("Enter an integer between " + minValue + " and " + maxValue + ": ", minValue, maxValue);
        System.out.println("Valid input: " + userInput);
    }
}
