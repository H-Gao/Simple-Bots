import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public class Hacks 
{
	public static void main(String[] args) throws Exception
	{
		Thread.sleep(10000);
		
		Robot r = new Robot();
		
		while (true)
		{
			r.mouseMove(830, 470);
			r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			
			r.mouseMove(940, 185);
			r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		}
	}
}
