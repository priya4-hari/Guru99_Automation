package TestCase11;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test11 {
	WebDriver driver;
	String BaseURL;
	@BeforeTest
	public void setup()
	{
		driver = new EdgeDriver();
		BaseURL="http://live.techpanda.org/index.php/backendlogin";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test
	public void testing() throws InterruptedException
	{
		driver.get(BaseURL);
		File fileLocation1 = new File("C:\\Users\\admin\\Downloads");
		File[] total_file1 = fileLocation1.listFiles();
		int count1 = total_file1.length;
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");
		driver.findElement(By.xpath("//input[@title='Login']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='close']")).click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Sales']"))).build().perform();
		driver.findElement(By.xpath("//a/span[text()='Orders']")).click();
		Select sel1 = new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_filter_status']")));
		sel1.selectByVisibleText("Canceled");
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("order_ids")).click();
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_massaction-select']")));
		sel2.selectByVisibleText("Print Invoices");
		driver.findElement(By.xpath("//span[text()='Submit']")).click();
		String errMsg = driver.findElement(By.xpath("//li[@class='error-msg']/ul/li/span")).getText();
		System.out.println(errMsg);
		try {
			Assert.assertEquals(errMsg, "There are no printable documents related to selected orders.");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		Select sel3 = new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_filter_status']")));
		sel3.selectByVisibleText("Complete");
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("order_ids")).click();
		Select sel4 = new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_massaction-select']")));
		sel4.selectByVisibleText("Print Invoices");
		driver.findElement(By.xpath("//span[text()='Submit']")).click();
		File fileLocation = new File("C:\\Users\\admin\\Downloads");
		File[] total_file = fileLocation.listFiles();
		int count = total_file.length;
		if(count == (count1+1))
		{
			System.out.println("File downloaded successfully!");
		}	
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
