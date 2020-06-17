import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Akshay Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		// Finding the number of frames present on application
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		WebElement frameLocator = driver.findElement(By.tagName("iframe"));
		// Switching to frames
		driver.switchTo().frame(frameLocator);
		// Actions class is used for mouse and keyboard interactions
		Actions a = new Actions(driver);
		WebElement dragabble = driver.findElement(By.id("draggable"));
		WebElement dropabble = driver.findElement(By.id("droppable"));
		// drag and drop source to target
		a.dragAndDrop(dragabble, dropabble).build().perform();
		// Switching back to web-page coming of out of frames
		driver.switchTo().defaultContent();
		driver.close();

	}

}
