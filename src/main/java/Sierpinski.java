import processing.core.PApplet;

/**
 * Created by dusti on 10/17/2016.
 */
public class Sierpinski extends PApplet {
    @Override
    public void settings() {
        //set the size of the window
        size(500, 500);
    }

    @Override
    public void setup() {
        //fill the background with white
        background(255);
        noLoop();
    }

    @Override
    public void draw() {
        loadPixels();
        pixels[width / 2] = color(0);

        for (int y = 1; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int i = pixelIndex(x, y);
                int leftParentI = pixelIndex((x - 1 + width) % width, y - 1);
                int rightParentI = pixelIndex((x + 1) % width, y - 1);
                if (xor(pixels[leftParentI], pixels[rightParentI])) {
                    pixels[i] = color(0);
                }
            }
        }

        updatePixels();
    }

    private boolean xor(int color1, int color2) {
        return (color1 == color(0) && color2 != color(0)) || (color2 == color(0) && color1 != color(0));
    }

    public int pixelIndex(int x, int y) {
        return x + y * width;
    }

    public static void main(String[] args) {
        PApplet.main("Sierpinski");
    }
}
