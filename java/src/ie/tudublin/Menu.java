package ie.tudublin;

import java.util.ArrayList;

import c17335606.*;
import processing.core.PApplet;
import java.lang.String;



public class Menu extends PApplet
{
    ArrayList<String> tracks = new ArrayList<String>();
    float border;
    float left;

    float w;
    float h;
    float headerSpace;
    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));

        border = width * 0.1f;
        left = width * 0.05f;

        w = width * 0.3f;
        h = height * 0.1f;
        headerSpace = height * 0.3f;
        
        //fullScreen(P3D, SPAN);
    }

    public void loadToTracks()
    {
        tracks.add("BICEP-GLUE.mp3");
        tracks.add("heroplanet.mp3");
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            //RotatingAudioBands();   
        }
 
    }

    void displayMenu()
    {

        String header = "Music \nVisualiser";
        pushMatrix();
        textSize(50);
        textAlign(CENTER);
        text(header,  width / 2, h );
        popMatrix();

        pushMatrix();
        for(int i = 0 ; i < tracks.size() ; i ++)
        {
            float y = map(i, 0, tracks.size(), headerSpace - border, (height *0.8f) - border);

            fill(255);
            rect((width /2) - w / 2 , y, w, h);
            fill(0);
            textSize(25);
            textAlign(LEFT, CENTER);
            // Organise the name of the file to be displayed by removing .mp3 and replacing "-" with " by "
            //
            String TName = tracks.get(i);
            String newTName = TName.replace("-", " by ");
            newTName = newTName.substring(0, newTName.length() - 4);
            //print the song name in the boxes
            //
            text(newTName, (width /2) - w / 3, y + (h / 2));
        }
        popMatrix();


    }

    public void draw()
    {
        displayMenu();
    }

    public void setup()
    {
        loadToTracks();
    }

}