import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousekeyboardinteractions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Akshay Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/gp/customer-reviews/RXKJ7XOL5UJZY?ASIN=B007Z9K45U");
		driver.manage().window().maximize();
		Actions a = new Actions(driver);// Actions class used for mouse and keyboard interactions
		// moving to particular element,Mouse interactions
		a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		// right clicking by mouse
		a.contextClick().build().perform();
		// Enter the letters in capital and select that entered letters by double click,
		// Keyboard interactions
		a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("akshay").doubleClick().build().perform();
		driver.close();
	}

}
