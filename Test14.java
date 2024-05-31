package TestCase14;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test14 {
	WebDriver driver;
	String baseURL;
	@BeforeTest
	public void setUP()
	{
		driver = new ChromeDriver();
		baseURL="http://live.techpanda.org/index.php/";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test
	public void testing()
	{
		driver.get(baseURL);
		driver.findElement(By.xpath("//a[text()='Advanced Search']")).click();
		driver.findElement(By.name("price[from]")).sendKeys("0");
		driver.findElement(By.name("price[to]")).sendKeys("150");
		driver.findElement(By.xpath("(//span[text()='Search'])[3]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='advanced-search-summary']/ul/li")).getText());
		List<WebElement> prod1 = driver.findElements(By.xpath("//h2[@class='product-name']/a"));
		for(WebElement e:prod1)
		{
			System.out.println(e.getText());
		}
		driver.findElement(By.xpath("//a[text()='Modify your search']")).click();
		driver.findElement(By.name("price[from]")).clear();
		driver.findElement(By.name("price[from]")).sendKeys("151");
		driver.findElement(By.name("price[to]")).clear();
		driver.findElement(By.name("price[to]")).sendKeys("1000");
		driver.findElement(By.xpath("(//span[text()='Search'])[3]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='advanced-search-summary']/ul/li")).getText());
		List<WebElement> prod2 = driver.findElements(By.xpath("//h2[@class='product-name']/a"));
		for(WebElement e1:prod2)
		{
			System.out.println(e1.getText());
		}
		
		
	}
	@AfterTest
	public void tearDown()
	{
		
	}

}
