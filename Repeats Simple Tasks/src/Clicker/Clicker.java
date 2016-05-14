package Clicker;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

public class Clicker 
{
	public static class ClickerRobot extends Thread implements Runnable
	{
		public ClickerRobot()
		{
			this.start();
		}
		
		public void run()
		{
			try
			{
				Robot r = new Robot();
				
				int x = 1;
				
				this.sleep(1000);
				r.mouseMove(1215, 750);
				this.sleep(1000);
				r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				r.mouseMove(1130, 490+75*x);
				this.sleep(1000);
				r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				r.mouseMove(1280, 580+70*x);
				this.sleep(1000);
				r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				
				r.mouseMove(1080, 220);
				this.sleep(1000);
				
				char[] a = "341164325".toCharArray();
				char[] b = "aaaaa".toCharArray();
				
				for (int i = 0;i < a.length;++i)
				{
					r.keyPress(KeyEvent.getExtendedKeyCodeForChar(a[i]));
					this.sleep(50);
				}
				
				this.sleep(1000);
				r.mouseMove(1080, 275);
				this.sleep(1000);
				r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				
				for (int i = 0;i < b.length;++i)
				{
					r.keyPress(KeyEvent.getExtendedKeyCodeForChar(b[i]));
					this.sleep(50);
				}
				
				this.sleep(1000);
				r.mouseMove(1170, 340);
				this.sleep(1000);
				r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				r.mouseMove(1125, 768);
				this.sleep(1000);
				r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
				r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				this.sleep(1000);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[])
	{
		ClickerRobot cr = new ClickerRobot();
	}
}
