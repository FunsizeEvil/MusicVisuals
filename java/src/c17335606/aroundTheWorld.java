// 28/04/2020
// Daniel Foley
// c17335606
// https://github.com/FunsizeEvil/MusicVisuals

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
        loadAudio("Glue-Bicep.mp3");
        getAudioPlayer().play();
        //startListening(); 
        
    }

    float radius = 200;
    float planetRadius[] = {50, 75, 100, 150, 200, 300, 400};
    float planetRot[] = {0,360, 100, 150, 340, 90, 220};

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
        noFill();
        stroke(255);
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, -500, 3000, 0, 0, 0, 0, 1, 0);
        //translate(0, 0, -250);

        rot += getAmplitude() / 8.0f;

        rotateY(rot);
        float[] bands = getSmoothedBands();
        for(int i = 0 ; i < 1 ; i ++)
        {
            for(int j = 0 ; j < 1 ; j ++)
            {
                float theta = map(i, 0, bands.length, 0, TWO_PI);
    
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                // float x = sin(theta) * radius;
                // float z = cos(theta) * radius;
                float x = sin(theta) * planetRadius[0];
                float z = cos(theta) * planetRadius[0];
                float h = bands[0];
                pushMatrix();
                translate((x + planetRot[0]), - h / 2 , z); 
                rotateY(theta + 100);
                sphere(h);
                popMatrix();
                
            }

            for(int j = 0 ; j < 1 ; j ++)
            {
                float theta = map(i, 0, bands.length, 0, TWO_PI);
    
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                // float x = sin(theta) * radius;
                // float z = cos(theta) * radius;
                float x = sin(theta) * planetRadius[1];
                float z = cos(theta) * planetRadius[1];
                float h = bands[1];
                pushMatrix();
                translate((x + planetRot[1]), - h / 2 , z);
                rotateY(theta);
                sphere(h);
                popMatrix();
                
            }

            for(int j = 0 ; j < 1 ; j ++)
            {
                float theta = map(i, 0, bands.length, 0, TWO_PI);
    
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                // float x = sin(theta) * radius;
                // float z = cos(theta) * radius;
                float x = sin(theta) * planetRadius[2];
                float z = cos(theta) * planetRadius[2];
                float h = bands[2];
                pushMatrix();
                translate((x + planetRot[2]), - h / 2 , z);
                rotateY(theta);
                sphere(h);
                popMatrix();
                
            }
            for(int j = 0 ; j < 1 ; j ++)
            {
                float theta = map(i, 0, bands.length, 0, TWO_PI);
    
                stroke(map(i, 0, bands.length, 0, 255), 255, 255);
                // float x = sin(theta) * radius;
                // float z = cos(theta) * radius;
                float x = sin(theta) * planetRadius[3];
                float z = cos(theta) * planetRadius[3];
                float h = bands[j];
                pushMatrix();
                translate((x + planetRot[3]), - h / 2 , z);
                rotateY(theta);
                sphere(h);
                popMatrix();
                
            }
            

            // float theta = map(i, 0, bands.length, 0, TWO_PI);

            // stroke(map(i, 0, bands.length, 0, 255), 255, 255);
            // float x = sin(theta) * radius;
            // float z = cos(theta) * radius;
            // // float x = sin(theta) * planetRadius[i];
            // // float z = cos(theta) * planetRadius[i];
            // float h = bands[i];
            // pushMatrix();
            // translate(x, - h / 2 , z);
            // rotateY(theta);
            // sphere(h);
            // popMatrix();
            
        }

    }
    float angle = 0;

}