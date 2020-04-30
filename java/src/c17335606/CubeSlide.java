package c17335606;

import ie.tudublin.Visual;
// import javafx.scene.shape.Box;

public class CubeSlide extends Visual
{
    boolean twocubes = false;

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
        if (key == '1')
        {
            twocubes = ! twocubes;

        }
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("heroplanet.mp3");
        //getAp().play();
        //startListening(); 
        
    }

    float smoothedBoxSize = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        fill(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255,255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -200);

        float x = 0;       
        float boxSize = 50 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);        
        

        pushMatrix();;
        translate(angle, 0);
        for(int i = 0; i < 6; i++)
        {   
            
            square(map(x,0,5,-100, 100), x + 50, 25);
        }
        square(x, x + 50, 25);
        popMatrix();

        angle += smoothedBoxSize /1000;
        if( angle == 120){
            angle = -120;
        }
    }
    float angle = 0;
} 