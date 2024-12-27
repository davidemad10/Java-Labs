public class ExceptionThrower {
    public void causeDivisionError()  {
        throw new MyException("Division by zero error!");
    }

    public void causeStringError() throws MyException {
        throw new MyException("String operation error!");
    }

    public void checkNegativeDivision(int numerator, int denominator) throws MyException {
        if (denominator < 0) {
            throw new MyException("Cannot divide by a negative number!");
        }
        System.out.println("Result: " + (numerator / denominator));
    }
}

