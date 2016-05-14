package Clicker;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;

public class AutoClicker 
{
	public static class clicker extends Thread implements Runnable
	{
		BufferedReader in;
		Robot r;
		
		public clicker()
		{
			try
			{
				r = new Robot();
				in = new BufferedReader(new FileReader("input.txt"));
				this.start();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public void run()
		{
			try
			{
				int repeated = 0;
				int repeatAmount = 0;
				
				BufferedImage img =  r.createScreenCapture(new Rectangle(1366, 768));
				
				this.sleep(1000);
				
				String temp;
				String[] input;
				while ((temp = in.readLine()) != null && (input = temp.split(" ")) != null)
				{
					if (repeatAmount > 0) ++repeated;
					
					System.out.println("Command: " + input[0]);
					
					switch (input[0])
					{
						case "move":
						{
							System.out.println("Moving to... " + input[1] + ", " + input[2]);
							
							int x = Integer.parseInt(input[1]);
							int y = Integer.parseInt(input[2]);
							
							r.mouseMove(x, y);
							break;
						}
						case "click":
						{
							System.out.println("Clicking");
							
							r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
							r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
							break;
						}
						case "type":
						{
							System.out.println("Typing " + input[1]);
							
							char[] a = input[1].toCharArray();
							
							for (int i = 0;i < a.length;++i)
							{
								r.keyPress(KeyEvent.getExtendedKeyCodeForChar(a[i]));
								this.sleep(100);
							}
							
							break;
						}
						case "wait":
						{
							System.out.println("Waiting " + input[1] + " milliseconds.");
							
							int amount = Integer.parseInt(input[1]);
							this.sleep(amount);
							
							break;
						}
						case "repeat":
						{
							System.out.println("Repeating.... " + input[1] + " times.");
							
							repeatAmount = 9000;
							
							break;
						}
					}
					
					this.sleep(500);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[])
	{
		clicker c = new clicker();
	}
}
