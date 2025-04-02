package com.task1.org;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
	WebDriver driver;
	@BeforeMethod
	public void driverSetup()
	{
		driver = new EdgeDriver();
		driver.get("https://demo.guru99.com/V4/");
		driver.manage().window().maximize();
	}
	@Test(priority=1,testName="Valid Username and Valid Password",enabled=false)
	public void TestCase_001()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr618432");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ydunyse");
		driver.findElement(By.name("btnLogin")).click();
		WebElement ele = driver.findElement(By.linkText("New Customer"));
		Assert.assertTrue(ele.isDisplayed());
	}
	@Test(priority=2,testName="Valid username and InValid Password",enabled=false)
	public void TestCase_002()
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr618432");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mani");
		driver.findElement(By.name("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		String exp = "User or Password is not valid";
		Assert.assertEquals(txt, exp);
		alert.accept();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='uid']")));
		String  actUsername = driver.findElement(By.xpath("//input[@name='uid']")).getText();
		String actPassword = driver.findElement(By.xpath("//input[@name='password']")).getText();
		Assert.assertTrue(actUsername.equals(""));
		Assert.assertTrue(actPassword.equals(""));
	}
	@Test(priority=3,testName="InValid Username and Valid Password",enabled=false)
	public void TestCase_003()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mani123");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ydunyse");
		driver.findElement(By.name("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		String exp = "User or Password is not valid";
		Assert.assertEquals(txt, exp);
		alert.accept();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='uid']")));
		String  actUsername = driver.findElement(By.xpath("//input[@name='uid']")).getText();
		String actPassword = driver.findElement(By.xpath("//input[@name='password']")).getText();
		Assert.assertTrue(actUsername.equals(""));
		Assert.assertTrue(actPassword.equals(""));
		
	}
	@Test(priority=4,testName="InValid Username and InValid Password",enabled=false)
	public void TestCase_004()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mani123");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mani");
		driver.findElement(By.name("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		String exp = "User or Password is not valid";
		Assert.assertEquals(txt, exp);
		alert.accept();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='uid']")));
		String  actUsername = driver.findElement(By.xpath("//input[@name='uid']")).getText();
		String actPassword = driver.findElement(By.xpath("//input[@name='password']")).getText();
		Assert.assertTrue(actUsername.equals(""));
		Assert.assertTrue(actPassword.equals(""));
	}
	@Test(priority=5,testName="Valid Username and Blank Password",enabled=true)
	public void TestCase_005()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr618432");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("");
		driver.findElement(By.name("btnLogin")).click();
		String act = driver.findElement(By.xpath("//tbody/tr[2]/td/label")).getText();
		String exp="Password must not be blank";
		Assert.assertEquals(act, exp);
	}
	@Test(priority=6,testName="Blank Username and Valid Password",enabled=false)
	public void TestCase_006()
	{
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ydunyse");
		driver.findElement(By.name("btnLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		String exp = "User or Password is not valid";
		Assert.assertEquals(txt, exp);
		alert.accept();
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='uid']")));
		String  actUsername = driver.findElement(By.xpath("//input[@name='uid']")).getText();
		String actPassword = driver.findElement(By.xpath("//input[@name='password']")).getText();
		Assert.assertTrue(actUsername.equals(""));
		Assert.assertTrue(actPassword.equals(""));
	}
	@AfterMethod
	public void tearDown()
	{
	//	driver.close();
	}
}
