package com.generic;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class LogInFunction {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, Throwable {
		
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.getTitle());
		
		driver.manage().window().maximize();
		Date date = new Date();
		System.out.println(date.toString());
				
		driver.findElement(By.xpath("(//*[@class='text-label text-active'])[1]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@name='originStation']")).getSize());
		driver.findElement(By.xpath("//*[@name='originStation']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		
		Select objSelect =new Select(driver.findElement(By.xpath("//*[@name='originStation']")));
		objSelect.selectByVisibleText("Amritsar (ATQ)");
		System.out.println("Amritsar (ATQ)\t" + "to\t");
		
		Select objSelect1 =new Select(driver.findElement(By.xpath("//*[@name='destinationStation']")));
		objSelect1.selectByVisibleText("Udaipur (UDR)");
		System.out.println("Udaipur (UDR)");
		
		Select objSelect2 = new Select(driver.findElement(By.xpath("//*[@class='wMed5s required']")));
		objSelect2.selectByVisibleText("Tomorrow, Tue 22 Dec, 2020");
		System.out.println("Tomorrow, Tue 22 Dec, 2020");
		
		driver.findElement(By.xpath("//*[@class='wLrg7t WM']")).sendKeys("123");
		System.out.println("Flight No - 123");
		
		driver.findElement(By.xpath("(//*[@value='Search'])[1]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@class='flight-status-error']")).getText());
		
		TakesScreenshot screenshot=((TakesScreenshot)driver);
		File source=screenshot.getScreenshotAs(OutputType.FILE); 
		Files.copy(source, new File("./Screenshot/ApplicationHomePage.png"));
		driver.findElement(By.xpath("//*[@class='flight-status-error']"));
		Thread.sleep(5000);
		driver.close();
	}
	

}
