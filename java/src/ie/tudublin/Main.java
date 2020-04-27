package ie.tudublin;

<<<<<<< HEAD
import c17335606.CubeVisual;
import c17335606.MyVisual;
=======
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
>>>>>>> cc0250fe11bfd31233735e224c9253c06ad1e5b1

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new RotatingAudioBands());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}