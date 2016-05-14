package LookingFor;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javax.swing.ImageIcon;

public class WifiClicker extends Thread implements Runnable
{
	public WifiClicker()
	{
		this.start();
	}
	
	public void run()
	{
		try
		{
			Robot r = new Robot();
			
			int nameLoc = 0;
			
			this.sleep(500);
			
			r.mouseMove(1210, 750);
			r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			
			this.sleep(1000);
			
			nameLoc = findLocation(r);
			System.out.println(nameLoc);
			
			this.sleep(1000);
			r.mouseMove(1095, nameLoc + 460);
			r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			
			this.sleep(1000);
			int boxLoc = findBox(r);
			System.out.println(boxLoc);
			
			this.sleep(1000);
			r.mouseMove(1275, 400+boxLoc);
			r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			
			this.sleep(10000);
			r.mouseMove(1085, 220);
			r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			
			char[] a = "341164325".toCharArray();
			
			for (int i = 0;i < a.length;++i)
			{
				r.keyPress(KeyEvent.getExtendedKeyCodeForChar(a[i]));
				r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(a[i]));
				this.sleep(100);
			}
			
			this.sleep(500);
			r.mouseMove(1085, 275);
			r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			
			char[] b = "85k9p52q".toCharArray();
			
			for (int i = 0;i < b.length;++i)
			{
				r.keyPress(KeyEvent.getExtendedKeyCodeForChar(b[i]));
				r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(b[i]));
				this.sleep(100);
			}
			
			this.sleep(500);
			r.mouseMove(1170, 335);
			r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
			
			this.sleep(500);
			r.mouseMove(1135, 370);
			r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int findLocation(Robot r)
	{
		WritableRaster target = r.createScreenCapture(new Rectangle(1366, 768)).getRaster();
		
		Image img = new ImageIcon("C:\\Judo Workspace\\AlgorithmIdeas\\LockrSoftware\\Chemistry Print Outs\\LookFor.png").getImage();
		BufferedImage bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		bimg.getGraphics().drawImage(img, 0, 0, null);
		
		WritableRaster source = bimg.getRaster();
		
		for (int k = 0;k < 20;++k)
		for (int i = 0;i < 280;++i)
		{
			boolean isSame = true;
			
			for (int y = 0;y < 11;++y)
			{
				for (int x = 0;x < 86;++x)
				{
					int[] pix1 = target.getPixel(x+1095-10+k, y+448+i, new int[3]);
					int[] pix2 = source.getPixel(x, y, new int[3]);
					
					//Move 180, 130.
					if (!same(pix1, pix2))
					{
						isSame = false;
						break;
					}
				}
				
				if (!isSame) break;
			}
			
			if (isSame) 
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public int findBox(Robot r)
	{
		WritableRaster target = r.createScreenCapture(new Rectangle(1366, 768)).getRaster();
		
		Image img = new ImageIcon("C:\\Judo Workspace\\AlgorithmIdeas\\LockrSoftware\\Chemistry Print Outs\\LookFor2.png").getImage();
		BufferedImage bimg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
		bimg.getGraphics().drawImage(img, 0, 0, null);
		
		WritableRaster source = bimg.getRaster();
		
		for (int i = 0;i < 335;++i)
		{
			boolean isSame = true;
			
			for (int y = 0;y < 32;++y)
			{
				for (int x = 0;x < 90;++x)
				{			
					int[] pix1 = target.getPixel(x+1236, y+400+i, new int[3]);
					int[] pix2 = source.getPixel(x, y, new int[3]);
					
					//Move 180, 130.
					if (!same(pix1, pix2))
					{
						isSame = false;
						break;
					}
				}
				
				if (!isSame) break;
			}
			
			if (isSame) 
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public boolean same(int[] a, int[] b)
	{
		int calibration = 60;
		
		for (int i = 0;i < 3;++i)
		{
			if (((a[i]-calibration) > b[i]) || ((a[i]+calibration) < b[i]))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String args[])
	{
		WifiClicker w = new WifiClicker();
	}
}
