package Cheats;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Cheats 
{
	public static void main(String args[]) throws Exception
	{
		Robot r = new Robot();
		
		long startTime = System.currentTimeMillis();
		
		int a = 2000;
		
		while (true)
		{
			long timePassed = System.currentTimeMillis() - startTime;
			
			if (timePassed < 20 * 1000 && timePassed%50==0) --a;
			
			BufferedImage bImg = r.createScreenCapture(new Rectangle(550  + (int)(timePassed/a), 220, 10, 1));
			BufferedImage bImg2 = r.createScreenCapture(new Rectangle(545  + (int)(timePassed/a), 182, 10, 1));
			BufferedImage bImg3 = r.createScreenCapture(new Rectangle(100, 100, 1, 1));
			
			for (int i = 0;i < 10;++i)
			{
				if (bImg.getRGB(i, 0) == new Color(83, 83, 83).getRGB() || bImg.getRGB(i, 0) == new Color(172, 172, 172).getRGB())
				{
					System.out.println("***" + timePassed);
					r.keyRelease(KeyEvent.VK_DOWN);
					r.keyPress(KeyEvent.VK_UP);
				}
				else
				{
					if (bImg2.getRGB(i, 0) == new Color(83, 83, 83).getRGB() || bImg2.getRGB(i, 0) == new Color(172, 172, 172).getRGB())
					{
						r.keyPress(KeyEvent.VK_DOWN);
					}
				}
			}
			
			int grayVal = new Color(bImg3.getRGB(0, 0)).getRed();
			
			if (grayVal < 220 && grayVal > 20)
			{
				System.out.println("HELLO");
				r.keyRelease(KeyEvent.VK_DOWN);
				r.keyPress(KeyEvent.VK_UP);
			}
		}
	}
}
