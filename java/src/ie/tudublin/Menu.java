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

    float boxW;
    float boxH;
    float headerSpace;
    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));

        border = width * 0.1f;
        left = width * 0.05f;

        boxW = width * 0.3f;
        boxH = height * 0.1f;
        headerSpace = height * 0.3f;
        
        //fullScreen(P3D, SPAN);
    }

    public void loadToTracks()
    {
        tracks.add("Glue-Bicep.mp3");
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

        String header = "Music Visualiser";
        pushMatrix();
        textSize(50);
        textAlign(CENTER);
        text(header,  width / 2, boxH );
        popMatrix();

        pushMatrix();
        for(int i = 0 ; i < tracks.size() ; i ++)
        {
            float y = map(i, 0, tracks.size(), headerSpace - border, (height *0.8f) - border);

            fill(255);
            rect((width /2) - boxW/ 2 , y, boxW, boxH);
            fill(0);
            textSize(25);
            textAlign(LEFT, CENTER);
            // Organise the name of the file to be displayed by removing .mp3 and replacing "-" with " by "
            //
            String TName = tracks.get(i);
            String newTName = TName.replace("-", " \nby ");
            newTName = newTName.substring(0, newTName.length() - 4);
            //print the song name in the boxes
            //
            text(newTName, (width /2) - boxW / 3, y + (boxH / 2));
        }
        popMatrix();


    }

    //Checks for mouse press and if the user clicked on a box to choose a track
    //
    public void mousePressed() 
    {
        
        System.out.println("mouse Pressed");
        for(int i = 0 ; i < tracks.size() ; i ++)
        {
            //maps the Y coordinate 
            //
            float y = map(i, 0, tracks.size(),  headerSpace - border, (height *0.8f) - border);
            //checks if the mouse x is within the width of a box anf the height of a box
            //
            if (mouseX > (width /2) - boxW/ 2 && mouseX < (width /2) + boxW/ 2
                && mouseY > y  && mouseY < y + boxH                 
                )
                {
                    System.out.println("now playing " + tracks.get(i));
                    String[] a = {"AroundTheWorld"};
                    //open a new window for the sketch
                    processing.core.PApplet.runSketch( a, new aroundTheWorld());

                    // try catch to wait and then calll another sketch
                    //
                    try{

                        Thread.sleep(5000);
                    }
                    catch(InterruptedException ex){
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("awoken from sleep");
                    String[] b = {"CubeVisual"};
                    processing.core.PApplet.runSketch(b, new CubeVisual());
                    break;
                }

        }
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