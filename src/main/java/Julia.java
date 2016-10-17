import processing.core.PApplet;

/**
 * Created by dusti on 10/17/2016.
 */
public class Julia extends PApplet {
    public static final int ITERATIONS = 100;

    @Override
    public void settings() {
        size(500, 500);
    }

    @Override
    public void setup() {
        colorMode(HSB);
    }

    @Override
    public void draw() {
        loadPixels();
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color(map(intensity(complexFromXY(i % width, i / width), complexFromXY(mouseX, mouseY)), 0, ITERATIONS, 0, 255), 255, 255);
        }
        updatePixels();
    }

    public Complex juliaFunction(Complex z, Complex c) {
        return z.multiply(z).add(c);
    }

    public int intensity(Complex x, Complex c) {
        int count = 0;
        while (x.abs() < 2 && count < ITERATIONS) {
            x = juliaFunction(x, c);
            count++;
        }
        return count;
    }

    public Complex complexFromXY(int x, int y) {
        return new Complex(
                map(x, 0, width, -1, 1),
                map(y, 0, height, -1, 1)
        );
    }

    public static void main(String[] args) {
        PApplet.main("Julia");
    }
}
