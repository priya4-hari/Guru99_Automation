package com.Day2.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day2_Task1 {
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.firefox.driver", "C:\\Users\\harip\\Guru99_Projects\\Task1_Day2\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//LAUNCH THE APPLICATION URL
		driver.get("https://demo.guru99.com/V4/");
		
		//ENTER AN USERNAME
		driver.findElement(By.cssSelector("input[name='uid']")).sendKeys("mngr618432");
		
		//ENTER PASSWORD
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Ydunyse");
		
		//CLICK ON LOGIN BUTTON
		driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
		
		driver.close();
	}

}
