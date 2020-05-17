// 01/05/2020
// Daniel Foley
// c17335606
// https://github.com/FunsizeEvil/MusicVisuals

// This Visual creates a 6 x 6 pattern with a cube inside a sphere.
// the size and colour reacts to the amplitude and the 

package c17335606;

import ie.tudublin.Visual;

public class PolyTest extends Visual
{

    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
    }


    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("heroplanet.mp3");
        getAudioPlayer().cue(0);
        getAudioPlayer().play();
    }

    float smoothedSize = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map((getSmoothedAmplitude() * 2), 0, 1, 0, 255), 255, 255);
        camera(750, 750, 1500, 750, 750, -1, 0, 1, 0);
        translate(0, 0, -250);
               
        float size = 50 + (getAmplitude() * 300);
        // lerp the size to make it less jumpy
        //
        smoothedSize = lerp(smoothedSize, size, 0.2f);        

        float x = 0;
        float y = 0;
        // nested for loop to print the pattern with a rotating cube inside 
        // a sphere.
        for(int i = 0; i < 6; i++)
        {
            for(int j= 0; j< 6; j++)
            {
                pushMatrix();
                // set the co ordinates
                translate(x, y, 0);
                //set the stroke coloured maped from the amplitude to 
                // the HSB limit
                stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
                fill(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
                // Rotate the cube a sphere
                rotateY(angle);
                rotateX(angle);
                box(smoothedSize);
                strokeWeight(1);
                noFill();
                popMatrix();
                pushMatrix();
                translate(x, y, 0);
                sphere(smoothedSize *1.5f);
                popMatrix();
                //increment y
                y += 300;
            }
            // Reset y to 0 and move the x along 
            //
            y = 0;
            x += 300;
        }
        angle += 0.01f;
    }
    float angle = 0;
} 