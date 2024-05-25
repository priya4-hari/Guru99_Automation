package TestCase12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test12 {
	WebDriver driver;
	String baseURL;
	String input1 = "Have a Nice";
	String input2 = "Wow product";
	String input22 = input2.toUpperCase();
	String input3 = "Priya";
	String input33 = input3.toUpperCase();

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		baseURL = "http://live.techpanda.org/";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void testing() throws InterruptedException {
		driver.get(baseURL);
		driver.navigate().to("http://live.techpanda.org/index.php/review/product/list/id/1/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)");
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,850)");
		driver.findElement(By.id("Quality 1_5")).click();
		driver.findElement(By.id("review_field")).sendKeys(input1);
		driver.findElement(By.id("summary_field")).sendKeys(input2);
		driver.findElement(By.id("nickname_field")).sendKeys(input3);
		driver.findElement(By.xpath("//span[text()='Submit Review']")).click();
		driver.navigate().to("http://live.techpanda.org/index.php/backendlogin");
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");
		driver.findElement(By.xpath("//input[@title='Login']")).click();
		driver.findElement(By.xpath("//span[text()='close']")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Catalog']"))).build().perform();
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Reviews and Ratings']"))).build().perform();
		action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Customer Reviews']"))).build().perform();
		driver.findElement(By.xpath("//span[text()='Pending Reviews']")).click();
		driver.findElement(By.xpath("//span[text()='Created On']")).click();
		driver.findElement(By.xpath("//span[text()='Created On']")).click();
		driver.findElement(By.xpath("(//input[@name='reviews'])[1]")).click();
		driver.findElement(By.xpath("(//a[text()='Edit'])[1]")).click();
		Select sel = new Select(driver.findElement(By.id("status_id")));
		sel.selectByVisibleText("Approved");
		driver.findElement(By.xpath("//span[text()='Save Review']")).click();
		driver.navigate().to("http://live.techpanda.org/");
		driver.findElement(By.xpath("//a[@href='http://live.techpanda.org/index.php/mobile.html']")).click();
		driver.findElement(By.id("product-collection-image-1")).click();
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,800)");
		driver.findElement(By.xpath("(//span[text()='Reviews'])[1]")).click();
		String str1 = driver.findElement(By.xpath("//div[@class='box-collateral box-reviews']/dl/dt/a")).getText();
		String str2 = driver.findElement(By.xpath("//div[@class='box-collateral box-reviews']/dl/dd")).getText();
		String str3 = driver.findElement(By.xpath("//div[@class='box-collateral box-reviews']/dl/dd/table/tbody/tr/th"))
				.getText();
		int index = str2.indexOf(str3);
		String str22 = str2.substring(0, index);
		str22 = str22.trim();
		String str4 = driver.findElement(By.xpath("(//span[@class='review-meta'])[1]")).getText();
		try {
			Assert.assertEquals(str1, input22);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Assert.assertEquals(str22, input1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] p = str4.split(" ");
		String arr = p[2];
		try {
			Assert.assertEquals(arr, input33);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
