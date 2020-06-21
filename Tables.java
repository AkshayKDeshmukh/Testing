import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int sum = 0;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Akshay Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/18970/pak-vs-sl-2nd-t20i-pakistan-v-sri-lanka-in-uae-2017");
		driver.manage().window().maximize();
// Limiting the webdriver scope
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
//finding he row count to iterate through the row
		int rowCount = table
				.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
// Getting the value of row to and summing them up to get the total score
		for (int i = 0; i < rowCount - 2; i++) {
			String row3 = table
					.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i)
					.getText();
			int score = Integer.parseInt(row3);
			sum = sum + score;
		}
// Getting extras values
		String extrasString = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText();
		int extras = Integer.parseInt(extrasString);
// Summing up score and extras to get total score
		int totalSum = sum + extras;
// Getting the total score count displayed on table
		String TotalString = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]")).getText();
		int total = Integer.parseInt(TotalString);
//Comparing the total score we got through code and total count displayed on table of webpage.
		if (totalSum == total) {
			System.out.println("Score Matched");
		} else {
			System.out.println("Score not matched");
		}
		driver.close();

	}

}
