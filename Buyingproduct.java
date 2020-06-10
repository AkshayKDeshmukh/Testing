import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buyingproduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Akshay Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// add item to cart
		addItems(driver);
		// proceed to checkout the added item
		checkout(driver);
		// Placing the order
		placeOrder(driver);

	}

	public static void addItems(WebDriver driver) {
		String[] vegitables = { "Cauliflower", "Beetroot", "Beans", "Potato", "Musk Melon" };
		List<WebElement> products = driver.findElements(By.cssSelector(".product-name"));
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			String[] spiltedName = name.split("-");
			String formattedname = spiltedName[0].trim();
			List<String> vegatablesNeeded = Arrays.asList(vegitables); // coverting array to arraylist at run time
			// Checking name is present in the array and then clicking on item present in
			// the arraylist
			if (vegatablesNeeded.contains(formattedname)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product']/div/button")).get(i).click();
				if (j == vegitables.length) {
					// Once all items are added to cart come out of the loop
					break;
				}
			}
		}

	}

	public static void checkout(WebDriver driver) {
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		String promoCodeInfo = driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
		System.out.println(promoCodeInfo);
		// driver.quit();

	}

	public static void placeOrder(WebDriver driver) {
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		Select s = new Select(driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select")));
		s.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		String thanksStatement = driver
				.findElement(By.xpath("//span[contains(text(),'Thank you, your order has been placed successfully')]"))
				.getText();
		System.out.println(thanksStatement);
		driver.close();
	}
}
