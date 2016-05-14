package Hacks;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Hacks 
{
	public static void main(String[] args)
	{
		try
		{
			Robot r = new Robot();
			Thread.sleep(2000);
			
			while (true)
			{
				for (int i = 97;i <= 122;++i)
				{
					r.keyPress(KeyEvent.getExtendedKeyCodeForChar(i));
					r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(i));
				}
					
				for (int i = 122;i >= 97;--i)
				{
					r.keyPress(KeyEvent.getExtendedKeyCodeForChar(i));
					r.keyRelease(KeyEvent.getExtendedKeyCodeForChar(i));
				}
				
				Thread.sleep(40);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
