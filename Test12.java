//Testcase12
package TestCase12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test12 {
	WebDriver driver;
	String baseURL;
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		baseURL="http://live.techpanda.org/";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test
	public void testing() throws InterruptedException
	{
		driver.get(baseURL);
		driver.navigate().to("http://live.techpanda.org/index.php/review/product/list/id/1/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,850)");
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,850)");
		driver.findElement(By.id("Quality 1_5")).click();
		driver.findElement(By.id("review_field")).sendKeys("Have a Nice!");
		driver.findElement(By.id("summary_field")).sendKeys("NICE!");
		driver.findElement(By.id("nickname_field")).sendKeys("Priya");
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
		driver.findElement(By.xpath("//span[text()='Save Review']"));
		driver.navigate().to("http://live.techpanda.org/");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	@AfterTest
	public void tearDown()
	{
		
	}

}
