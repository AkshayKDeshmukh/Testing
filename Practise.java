import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Akshay Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		radioButton(driver);
		toFromDropdowns(driver);
		calender(driver);
		passengerDropdown(driver);
		checkBox(driver);
		searchButton(driver);
		driver.close();

	}

	public static void passengerDropdown(WebDriver driver) {
		// Clicking on dropdown icon
		WebElement passengers = driver.findElement(By.id("divpaxinfo"));
		passengers.click();

		// Adult dropdown
		WebElement adultWebElement = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select adult = new Select(adultWebElement);
		adult.selectByIndex(4);
		System.out.println(passengers.getText());
		adult.selectByValue("5");
		System.out.println(passengers.getText());

		// child dropdown
		WebElement childWebElement = driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
		Select child = new Select(childWebElement);
		child.selectByVisibleText("3");
		System.out.println(passengers.getText());

//		Infant Element
		WebElement infantElement = driver.findElement(By.id("ctl00_mainContent_ddl_Infant"));
		Select infant = new Select(infantElement);
		infant.selectByIndex(2);

		// getting text of field
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// currencyDropdown
		WebElement currencyElement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select currency = new Select(currencyElement);
		currency.selectByValue("USD");

	}

	public static void toFromDropdowns(WebDriver driver) throws InterruptedException {
		WebDriverWait from = new WebDriverWait(driver, 8);
		from.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_mainContent_btn_FindFlights")));

		// from.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();

		from.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@value='BHO']")));
		driver.findElement(By.xpath("//a[@value='BHO']")).click();
		from.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@value='GOP'])[2]")));
		driver.findElement(By.xpath("(//a[@value='GOP'])[2]")).click();
	}

	public static void calender(WebDriver driver) {
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		String calenderStatus = driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style");
		if (calenderStatus.contains("1")) {
			System.out.println("Calender is enabled");

		} else
			System.out.println("Calender is disbled");

	}

	public static void radioButton(WebDriver driver) throws InterruptedException {
		WebDriverWait radibtn = new WebDriverWait(driver, 5);
		radibtn.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")));
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();// radio button

	}

	public static void checkBox(WebDriver driver) {
		int checkboxSize = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
		System.out.println("Number of checkboxes on page are:" + checkboxSize);
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_StudentDiscount']")).click();

	}

	public static void searchButton(WebDriver driver) {
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		WebDriverWait search = new WebDriverWait(driver, 8);
		search.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".no_flights.padding-left-15"))));
		System.out.println(driver.findElement(By.cssSelector(".no_flights.padding-left-15")).getText());
	}

}
