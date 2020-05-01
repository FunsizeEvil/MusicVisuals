package ie.tudublin;

import c17335606.*;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeInSphere());		
	}

	public static void main(String[] args) throws Exception
	{
		Main main = new Main();
		main.startUI();			
	}
}