public class Complex<T extends Number> {
    private T real;
    private T imaginary;

    public Complex(T real, T imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public T getReal() {
        return real;
    }

    public T getImaginary() {
        return imaginary;
    }

    public String display() {
        return real + " + " + imaginary + "i";
    }

    // Method to add two complex numbers
    public static Complex<Double> add(Complex<Double> c1, Complex<Double> c2) {
        Double realPart = c1.getReal() + c2.getReal();
        Double imaginaryPart = c1.getImaginary() + c2.getImaginary();
        return new Complex<>(realPart, imaginaryPart);
    }
    

    // Method to subtract two complex numbers
    public static  Complex<Double> subtract(Complex<Double> c1, Complex<Double> c2) {
        Double realPart = c1.getReal() - c2.getReal();
        Double imaginaryPart = c1.getImaginary() - c2.getImaginary();
        return new Complex<>(realPart, imaginaryPart);
    }

    // Method to multiply two complex numbers
    public static Complex<Double> multiply(Complex<Double> c1, Complex<Double> c2) {
        Double realPart = c1.getReal() * c2.getReal() - c1.getImaginary() * c2.getImaginary();
        Double imaginaryPart = c1.getReal() * c2.getImaginary() + c1.getImaginary() * c2.getReal();
        return new Complex<>(realPart, imaginaryPart);
    }
    

    // Method to divide two complex numbers
    public static Complex<Double> divide(Complex<Double> c1, Complex<Double> c2) {
        double denominator = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginary(), 2);
        double realPart = (c1.getReal() * c2.getReal() + c1.getImaginary() * c2.getImaginary()) / denominator;
        double imaginaryPart = (c1.getImaginary() * c2.getReal() - c1.getReal() * c2.getImaginary()) / denominator;
        return new Complex<>(realPart, imaginaryPart);
    }
}

