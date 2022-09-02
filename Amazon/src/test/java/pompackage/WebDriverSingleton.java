package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.amazon.qa.base.Testbase;

public class WebDriverSingleton extends Testbase{
	//singleton


		   public static WebDriver driver;

		   public static WebDriver getInstance() {
		     if (driver == null) {
		       driver = new ChromeDriver();
		     }
		     return driver;
		   }

		}
