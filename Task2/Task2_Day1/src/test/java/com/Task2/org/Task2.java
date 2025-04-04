package com.Task2.org;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {
	WebDriver driver;
	@BeforeMethod
	public void driverSetup()
	{
		System.setProperty("webdriver.firefox.driver", Util.loc);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Util.BaseUrl);
		String actual = driver.getTitle();
		String expect = "Guru99 Bank Home Page";
		Assert.assertEquals(actual, expect);
	}
	@Test
	public void TC_001()
	{
		driver.findElement(By.name("uid")).sendKeys(Util.Username1);
		driver.findElement(By.name("password")).sendKeys(Util.Password1);
		driver.findElement(By.name("btnLogin")).click();
		String actual1 = driver.getTitle();
		String expect1 = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(actual1, expect1);
	}
	@Test
	public void TC_002()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(Util.Username2);
		driver.findElement(By.name("password")).sendKeys(Util.Password2);
		driver.findElement(By.name("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String actual2 = alert.getText();
		String expect2 = "User or Password is not valid";
		Assert.assertEquals(actual2, expect2);
		alert.accept();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
		String actual3 = driver.findElement(By.name("uid")).getText();
		String expect3 = "";
		Assert.assertEquals(actual3, expect3);
		String actual4 = driver.findElement(By.name("password")).getText();
		String expect4 = "";
		Assert.assertEquals(actual4, expect4);
		
	}
	@Test
	public void TC_003()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(Util.Username3);
		driver.findElement(By.name("password")).sendKeys(Util.Password3);
		driver.findElement(By.name("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String actual2 = alert.getText();
		String expect2 = "User or Password is not valid";
		Assert.assertEquals(actual2, expect2);
		alert.accept();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
		String actual3 = driver.findElement(By.name("uid")).getText();
		String expect3 = "";
		Assert.assertEquals(actual3, expect3);
		String actual4 = driver.findElement(By.name("password")).getText();
		String expect4 = "";
		Assert.assertEquals(actual4, expect4);
		
	}
	@Test
	public void TC_004()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(Util.Username4);
		driver.findElement(By.name("password")).sendKeys(Util.Password4);
		driver.findElement(By.name("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String actual2 = alert.getText();
		String expect2 = "User or Password is not valid";
		Assert.assertEquals(actual2, expect2);
		alert.accept();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
		String actual3 = driver.findElement(By.name("uid")).getText();
		String expect3 = "";
		Assert.assertEquals(actual3, expect3);
		String actual4 = driver.findElement(By.name("password")).getText();
		String expect4 = "";
		Assert.assertEquals(actual4, expect4);
		
	}
	@Test
	public void TC_005()
	{
		driver.findElement(By.name("uid")).sendKeys(Util.Username5);
		driver.findElement(By.name("password")).sendKeys(Util.Password5);
		driver.findElement(By.name("btnLogin")).click();
		String actual = driver.findElement(By.xpath("//tbody/tr[2]/td/label")).getText();
		String expect = "Password must not be blank";
		Assert.assertEquals(actual, expect);
	}
	@Test
	public void TC_006()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(Util.Username6);
		driver.findElement(By.name("password")).sendKeys(Util.Password6);
		driver.findElement(By.name("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String actual2 = alert.getText();
		String expect2 = "User or Password is not valid";
		Assert.assertEquals(actual2, expect2);
		alert.accept();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
		String actual3 = driver.findElement(By.name("uid")).getText();
		String expect3 = "";
		Assert.assertEquals(actual3, expect3);
		String actual4 = driver.findElement(By.name("password")).getText();
		String expect4 = "";
		Assert.assertEquals(actual4, expect4);
		
	}
	@Test
	public void TC_007()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(Util.Username7);
		driver.findElement(By.name("password")).sendKeys(Util.Password7);
		driver.findElement(By.name("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String actual2 = alert.getText();
		String expect2 = "User or Password is not valid";
		Assert.assertEquals(actual2, expect2);
		alert.accept();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));
		String actual3 = driver.findElement(By.name("uid")).getText();
		String expect3 = "";
		Assert.assertEquals(actual3, expect3);
		String actual4 = driver.findElement(By.name("password")).getText();
		String expect4 = "";
		Assert.assertEquals(actual4, expect4);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
