package ie.tudublin;

import c17335606.CubeVisual;
import c17335606.MyVisual;
import c17335606.RotatingAudioBands;
import c17335606.aroundTheWorld;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Menu());		
	}

	public static void main(String[] args) throws Exception
	{
		Main main = new Main();
		main.startUI();			
	}
}