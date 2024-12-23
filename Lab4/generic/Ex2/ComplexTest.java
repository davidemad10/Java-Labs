public class ComplexTest {

    public static void main(String[] args) {
        // Create two complex numbers
        Complex<Double> complex1 = new Complex<>(3.0, 4.0);  
        Complex<Double> complex2 = new Complex<>(1.0, 2.0);

        // Display complex numbers
        System.out.println("Complex Number 1: " + complex1.display());
        System.out.println("Complex Number 2: " + complex2.display());

        // Add two complex numbers
        Complex<Double> resultAdd = Complex.add(complex1, complex2);
        System.out.println("Addition Result: " + resultAdd.display());

        // Subtract two complex numbers
        Complex<Double> resultSub = Complex.subtract(complex1, complex2);
        System.out.println("Subtraction Result: " + resultSub.display());

        // Multiply two complex numbers
        Complex<Double> resultMul = Complex.multiply(complex1, complex2);
        System.out.println("Multiplication Result: " + resultMul.display());

        // Divide two complex numbers
        Complex<Double> resultDiv = Complex.divide(complex1, complex2);
        System.out.println("Division Result: " + resultDiv.display());
    }
}

