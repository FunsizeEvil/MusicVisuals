// 30/04/2020
// Daniel Foley
// c17335606
// https://github.com/FunsizeEvil/MusicVisuals
// Shape is a class that extends Visual. I am using this class to call 
// other class shapes  which in turn are extened form TwodObject.java.
// the goal of this class is create a moving pattern of shapes that 
// will react to the music

package c17335606;

import java.util.ArrayList;

import ie.tudublin.Visual;


public class SHAPE extends Visual
{
    // create an Arraylist with objects based off twodObjects
    //
    public ArrayList<TwodObject> twodObjects = new ArrayList<TwodObject>();

    // Create the instance of each object from the class square
    Square square;

    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
    }

    public void setup()
    {
        //set the parameters
        square = new Square(this, 100, 100, 0, 0, 50);
        twodObjects.add(square);

        colorMode(HSB);
        //noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("heroplanet.mp3");
        getAudioPlayer().play();

    }

    public void draw()
    {

        calculateAverageAmplitude();
        // try
        // {
        //     calculateFFT();
        // }
        // catch(VisualException e)
        // {
        //     e.printStackTrace();
        // }
        pushMatrix();
        calculateAverageAmplitude();
        calculateFrequencyBands();
        background(0);
        stroke(255);

        // twodObjects.setRotation() += getAmplitude() / 8.0f;

        // rotateY(rotation);
        float[] bands = getSmoothedBands();

        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        fill(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255,255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -200);

        popMatrix();

        // for each object on the screen call render and update
        //
        for( int i = twodObjects.size() -1; i >= 0; i--){
            TwodObject b = twodObjects.get(i);
            b.render();
            b.update();
        }
    }
}



