import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webdriverscope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Akshay Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		// Finding the links count on the page
		int linksCount = driver.findElements(By.tagName("a")).size();
		System.out.println("There are " + linksCount + " on qa click academy page");
		// Finding the links count on the footer section of page
		WebElement footerSection = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		int footerLinksCount = footerSection.findElements(By.tagName("a")).size();
		System.out.println("There are " + footerLinksCount + " links in the footer section.");
		// Finding links count on first section in footer section of page
		WebElement firstFooterSection = footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int firstFooterSectionCount = firstFooterSection.findElements(By.tagName("a")).size();
		System.out.println("There are " + firstFooterSectionCount + " in the first section of footer");
		// Clicking on linking that are opened on different tabs
		for (int i = 1; i < firstFooterSectionCount; i++) {
			// by control+enter oon keyboard links gets open in different tabs
			String clickOnLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstFooterSection.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);
		}
		// Navigating to each and every window and getting title of each window
		Set<String> windowIds = driver.getWindowHandles(); // getting ids of windows
		Iterator<String> it = windowIds.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next()); // switching to each and every window which requires id of each window
													// (id is obtained by it.next() method)
			System.out.println("The title of window is " + driver.getTitle());
		}

		driver.quit(); // closing all windows opened by selenium script

	}

}
