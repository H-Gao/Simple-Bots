package Example;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;

public class ThousandTabs 
{
	public static void main(String args[])
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			
			int numberRun = Integer.parseInt(in.readLine());
			String website = in.readLine();
			
			for (int i = 0;i < numberRun;++i)
			Desktop.getDesktop().browse(new URI(website));
			
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

