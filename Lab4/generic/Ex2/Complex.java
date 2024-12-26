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
    public static <T extends Number> Complex<T> add(Complex<T> c1, Complex<T> c2) {
        T realPart = (T) Double.valueOf(c1.getReal().doubleValue() + c2.getReal().doubleValue());
        T imaginaryPart = (T) Double.valueOf(c1.getImaginary().doubleValue() + c2.getImaginary().doubleValue());
        return new Complex<>(realPart, imaginaryPart);
    }

    // Method to subtract two complex numbers
    public static <T extends Number> Complex<T> subtract(Complex<T> c1, Complex<T> c2) {
        T realPart = (T) Double.valueOf(c1.getReal().doubleValue() - c2.getReal().doubleValue());
        T imaginaryPart = (T) Double.valueOf(c1.getImaginary().doubleValue() - c2.getImaginary().doubleValue());
        return new Complex<>(realPart, imaginaryPart);
    }

    // Method to multiply two complex numbers
    public static <T extends Number> Complex<T> multiply(Complex<T> c1, Complex<T> c2) {
        T realPart = (T) Double.valueOf(c1.getReal().doubleValue() * c2.getReal().doubleValue()
                - c1.getImaginary().doubleValue() * c2.getImaginary().doubleValue());
        T imaginaryPart = (T) Double.valueOf(c1.getReal().doubleValue() * c2.getImaginary().doubleValue()
                + c1.getImaginary().doubleValue() * c2.getReal().doubleValue());
        return new Complex<>(realPart, imaginaryPart);
    }

    // Method to divide two complex numbers
    public static <T extends Number> Complex<T> divide(Complex<T> c1, Complex<T> c2) {
        double denominator = Math.pow(c2.getReal().doubleValue(), 2) + Math.pow(c2.getImaginary().doubleValue(), 2);
        T realPart = (T) Double.valueOf((c1.getReal().doubleValue() * c2.getReal().doubleValue()
                + c1.getImaginary().doubleValue() * c2.getImaginary().doubleValue()) / denominator);
        T imaginaryPart = (T) Double.valueOf((c1.getImaginary().doubleValue() * c2.getReal().doubleValue()
                - c1.getReal().doubleValue() * c2.getImaginary().doubleValue()) / denominator);
        return new Complex<>(realPart, imaginaryPart);
    }
}

