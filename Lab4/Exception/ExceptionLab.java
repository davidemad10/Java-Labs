import java.util.Scanner;

public class ExceptionLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExceptionThrower thrower = new ExceptionThrower();

        System.out.println("Choose an option:");
        System.out.println("1: Simulate division error");
        System.out.println("2: Simulate string error");
        System.out.println("3: Simulate division by negative number");

        try {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter two numbers to divide:");
                    int num1 = scanner.nextInt();
                    int num2 = scanner.nextInt();
                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero!");
                    }
                    System.out.println("Result: " + (num1 / num2));
                    break;

                case 2:
                    System.out.println("Enter a string:");
                    String input = scanner.next();
                    if (input.length() < 5) {
                        throw new MyException("String is too short!");
                    }
                    System.out.println("String accepted: " + input);
                    break;

                case 3:
                   System.out.println("Enter two numbers to divide:");
                    int numerator = scanner.nextInt();
                    int denominator = scanner.nextInt();
                    thrower.checkNegativeDivision(numerator, denominator);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());

        } catch (MyException e) {
            System.out.println("Caught a MyCustomException: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Caught an exception: " + e.getMessage());

        } finally {
            System.out.println("Program execution completed.");
        }
    }
}

