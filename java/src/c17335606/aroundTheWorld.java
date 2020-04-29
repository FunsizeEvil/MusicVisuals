// 28/04/2020
// Daniel Foley
// c17335606
// https://github.com/FunsizeEvil/MusicVisuals
// the visual is based off the solar system and inspired partly by
// Daft Punks "around the world". It Depicts 6 planets rotating around 
// the sun. Each planet grows with the magnitude of the band and all
// rotate around the sun in relation to the amplitude of the music.

package c17335606;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class aroundTheWorld extends Visual {


    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
 
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("heroplanet.mp3");
        getAudioPlayer().play();
        
    }
    // Create an array for each planets radius from the centre point
    // and one for the offset in rotation. Rotatino is done randomly
    // so as to give a more natural solar system look.
    float planetRadius[] = {0, 100, 200, 340, 380, 420, 500, 550, 200};
    float planetRot[] = {0, 100, 400, -1500, 100, -300, 200, 200};


    float smoothedBoxSize = 0;

    float rot = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        try
        {
            calculateFFT();
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        calculateFrequencyBands();
        background(0);
        stroke(255);
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, -3000, 100, 0, 0, 0, 0, 1, 0);

        rot += getAmplitude() / 8.0f;

        rotateY(rot);
        float[] bands = getSmoothedBands();
        for(int i = 0 ; i < 1 ; i ++)
        {
            for(int j = 0 ; j < bands.length ; j ++)
            {
                float theta = map(i, 0, bands.length, j, TWO_PI);
    
                stroke(map(j, 0, bands.length, 0, 255), 255, 255);
                float x = sin(theta) * planetRadius[j];
                float z = cos(theta) * planetRadius[j];
                float h = bands[j];
                pushMatrix();
                translate((x + planetRot[j]) , - h  / 2 , z); 
                rotateY(theta + planetRot[j]);
                // Allows the sun to be larger than the other planets
                //
                if(j == 0){
                    sphere(h);
                }else{
                    sphere(h / 3);
                }
                popMatrix();            
            }
        }
    }
    float angle = 0;

}