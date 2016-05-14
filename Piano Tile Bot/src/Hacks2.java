import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;


public class Hacks2 
{
	public static void main(String[] args) throws Exception
	{
		Thread.sleep(10000);
		
		int tick = 0;
		
		Robot r = new Robot();
		
		BufferedImage prev = r.createScreenCapture(new Rectangle(720, 520, 300, 20));
		
		while (true)
		{
			BufferedImage curr = r.createScreenCapture(new Rectangle(720, 520, 300, 20));
			
			boolean hasLag = false;
			
			for (int y = 0;y < 20;++y)
			{
				for (int x = 0;x < 300;++x)
				{
					if (curr.getRGB(x, y) != prev.getRGB(x, y))
					{
						hasLag = true;
						break;
					}
				}
			}
			
			prev = curr;
			
			if (!hasLag)
			for (int i = 0;i < 4;++i)
			{
				BufferedImage img = r.createScreenCapture(new Rectangle(700 + 70 * i, 560, 1, 1));
				
				Color c = new Color(img.getRGB(0, 0));
				
				if (c.getRed() < 82 && c.getBlue() < 82 && c.getGreen()  < 82)
				{
					r.mouseMove(720 + 70 * i, 570);
					r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
					r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
					break;
				}
			}
			
			if (tick > 400) System.exit(0);
			
			++tick;
		}
	}
}
