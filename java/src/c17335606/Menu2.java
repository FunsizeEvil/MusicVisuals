package c17335606;

import java.util.ArrayList;

import processing.core.PApplet;
import java.lang.String;



public class Menu2 extends PApplet 
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
        tracks.add("AroundTheWorld-DaftPunk.mp3");
        tracks.add("Glue-Bicep.mp3");
        tracks.add("heroplanet.mp3");
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            displayMenu();  
        }
 
    }

    void displayMenu()
    {

        String header = "Music Visualiser";
        String footer = "By Daniel Foley 2020. \nhttps://github.com/FunsizeEvil/MusicVisuals";
        pushMatrix();

        textSize(50);
        textAlign(CENTER);
        text(header,  width / 2, boxH );
        textSize(30);
        text(footer, width * 0.5f, height *0.9f);
        popMatrix();

        pushMatrix();
        for(int i = 0 ; i < tracks.size() ; i ++)
        {
            float y = map(i, 0, tracks.size(), headerSpace - border, (height *0.8f) - border);

            fill(255);
            rect((width /2) - boxW/ 2 , y, boxW, boxH,30);
            fill(0);
            textSize(22);
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
            
            String currentTrack = " "; 
            System.out.println(currentTrack);
            //maps the Y coordinate 
            //
            float y = map(i, 0, tracks.size(),  headerSpace - border, (height *0.8f) - border);
            //checks if the mouse x is within the width of a box anf the height of a box
            //
            if (mouseX > (width /2) - boxW/ 2 && mouseX < (width /2) + boxW/ 2
                && mouseY > y  && mouseY < y + boxH                 
                )
                {
                    currentTrack = tracks.get(i);

                    if(currentTrack.equals(tracks.get(i))) 
                    {
                        System.out.println("now playing " + tracks.get(i));
                        String[] b = {"AroundTheWorld"};
                        //open a new window for the sketch
                        colorMode(HSB);
                       // noCursor();
                        System.out.println(currentTrack);

                        // due to a bug, a switch statement would not work and
                        // for the option selection. 
                        // here is the command to launch my other original visual
                        // processing.core.PApplet.runSketch( b, new CubeInSphere());
                        processing.core.PApplet.runSketch( b, new AroundTheWorld());
                        break;
                    }else if(currentTrack.equals(tracks.get(i))) 
                    {
                        System.out.println("now playing " + tracks.get(i));
                        String[] c = {"CubeInSphere"};
                        //open a new window for the sketch
                        colorMode(HSB);
                       // noCursor();
                        System.out.println(currentTrack);

                            
                        processing.core.PApplet.runSketch( c, new CubeInSphere());
                        break;
                    }else if(currentTrack.equals(tracks.get(i))) 
                    {
                        System.out.println("now playing " + tracks.get(i));
                        String[] d = {"RotatingAudioBands"};
                        //open a new window for the sketch
                        colorMode(HSB);
                       // noCursor();
                        System.out.println(currentTrack);

                            
                        processing.core.PApplet.runSketch( d, new RotatingAudioBands());
                        break;
                    }
                
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

	/**
	 * @return the tracks
	 */
	public ArrayList<String> getTracks() {
		return tracks;
	}

	/**
	 * @param tracks the tracks to set
	 */
	public void setTracks(ArrayList<String> tracks) {
        this.tracks = tracks;
    }
}