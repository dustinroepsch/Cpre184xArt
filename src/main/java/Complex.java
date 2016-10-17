/**
 * Created by dusti on 10/17/2016.
 */
public class Complex {
    private double imag, real;

    public Complex(double imag, double real) {
        this.imag = imag;
        this.real = real;
    }

    public Complex add(Complex other) {
        return new Complex(
                this.real + other.real,
                this.imag + other.imag
        );
    }

    public Complex multiply(Complex other) {
        //(a + bi) * (d + ci) = ad + aci + bdi - bc
        return new Complex(
                this.real * other.real - this.imag * other.imag,
                this.real * other.imag + this.imag * other.real
        );
    }

    public double abs() {
        return Math.sqrt(this.imag * this.imag + this.real * this.real);
    }
}
