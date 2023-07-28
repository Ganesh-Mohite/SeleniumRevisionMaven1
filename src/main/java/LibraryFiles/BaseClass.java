package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	WebDriver d;
	
	public void initializeBrowser() throws IOException
	{
		d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.get(UtilityClass.getPFData("URL"));
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	
	
	
	
}
