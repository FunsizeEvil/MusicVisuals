package ie.tudublin;

import com.sun.glass.ui.Menu;

import c17335606.*;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Menu2());		
	}

	public static void main(String[] args) throws Exception
	{
		Main main = new Main();
		main.startUI();			
	}
}