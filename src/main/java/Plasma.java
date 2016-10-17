import processing.core.PApplet;

/**
 * Created by dusti on 10/17/2016.
 */
public class Plasma extends PApplet {
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
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int i = pixelIndex(x, y);
                float distanceFromCenter = dist(x, y, width / 2, height / 2);

                //black and white circle
                //pixels[i] = color(map(sin(distanceFromCenter / 30), -1, 1, 0, 255));

                //colored concentric circles
                //pixels[i] = color(map(sin(distanceFromCenter / 30), -1, 1, 0, 255), 255, 255);

                //shifting circles
                //pixels[i] = color((map(sin(distanceFromCenter / 30), -1, 1, 0, 255) + millis() / 30) % 255, 255, 255);

                //moving circles
                //pixels[i] = color(map(sin(distanceFromCenter / 30 + millis() / 1000f), -1, 1, 0, 255), 255, 255);

                //moving and shifting
                //pixels[i] = color((map(sin(distanceFromCenter / 30 + millis() / 1000f), -1, 1, 0, 255) + millis() / 30) % 255, 255, 255);

                //multiple origins moving and shifting
                pixels[i] = color((map(sin(distanceFromCenter / 30 + millis() / 1000f) + sin(dist(mouseX, mouseY,x, y) / 25), -2, 2, 0, 255) + millis() / 30) % 255, 255, 255);

            }
        }
        updatePixels();
    }

    public int pixelIndex(int x, int y) {
        return x + y * width;
    }

    public static void main(String[] args) {
        PApplet.main("Plasma");
    }
}
