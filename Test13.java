package TestCase13;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test13 {
	WebDriver driver;
	String baseURL;
	@BeforeTest
	public void setUP()
	{
		driver = new ChromeDriver();
		baseURL="http://live.techpanda.org/index.php/backendlogin";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	@Test
	public void testing() throws InterruptedException
	{
		driver.get(baseURL);
		driver.findElement(By.id("username")).sendKeys("user01");
		driver.findElement(By.id("login")).sendKeys("guru99com");
		driver.findElement(By.xpath("//input[@title='Login']")).click();
		driver.findElement(By.xpath("//a[@title='close']")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Sales']"))).build().perform();
		driver.findElement(By.xpath("//span[text()='Invoices']")).click();
		List<WebElement> listEle = driver.findElements(By.xpath("//table[@id='sales_invoice_grid_table']/tbody/tr/td[3]"));
		List<String> strEle = new ArrayList<>();
		for(WebElement e:listEle)
		{
			strEle.add(e.getText());
		}
		SimpleDateFormat dateForm = new SimpleDateFormat("MMM d, yyyy h:mm:ss a");
		List<Date> dateEle1 = new ArrayList<>();
		List<Date> dateEle2 = new ArrayList<>();
		for(String s:strEle)
		{
			try {
				dateEle1.add(dateForm.parse(s));
				dateEle2.add(dateForm.parse(s));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		Collections.sort(dateEle2,Collections.reverseOrder());
		if(dateEle1.equals(dateEle2))
		{
			System.out.println("Dates are Descending correctly!");
		}
		driver.findElement(By.xpath("//span[text()='Invoice Date']")).click();
		Thread.sleep(5000);
		List<WebElement> listEle1 = driver.findElements(By.xpath("//table[@id='sales_invoice_grid_table']/tbody/tr/td[3]"));
		List<String> strEle1 = new ArrayList<>();
		for(WebElement e1:listEle1)
		{
			strEle1.add(e1.getText());
		}
		SimpleDateFormat dateForm1 = new SimpleDateFormat("MMM d, yyyy h:mm:ss a");
		List<Date> dateEle3 = new ArrayList<>();
		List<Date> dateEle4 = new ArrayList<>();
		for(String s1:strEle1)
		{
			try {
				dateEle3.add(dateForm.parse(s1));
				dateEle4.add(dateForm.parse(s1));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		Collections.sort(dateEle4);
		if(dateEle3.equals(dateEle4))
		{
			System.out.println("Dates are Ascended successfully!");
		}	
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
