import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;

public class Drivercapabilities {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// general chrome profile is set by capabilities
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// Local chrome browser setting
		ChromeOptions ch = new ChromeOptions();
		ch.merge(dc);

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Akshay Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(ch);// passing the local chrome driver setting to driver object
		// Maximizing window
		driver.manage().window().maximize();
		// Deleting all cookies
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.co.in/");
		// converting driver object to takescreenshot form
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Storing the file in object src locally in pc by giving path
		FileUtils.copyFile(src, new File("C:\\Users\\Admin\\Desktop\\Akshay Selenium\\akshay.png"));
		driver.close();
	}

}
