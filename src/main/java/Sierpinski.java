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
    }

    @Override
    public void draw() {

    }

    public static void main(String[] args) {
        PApplet.main("Sierpinski");
    }
}
