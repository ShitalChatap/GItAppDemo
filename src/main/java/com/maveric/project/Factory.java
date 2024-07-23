package com.maveric.project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Factory 
{
	public static WebDriver getdriver() {
		// Explicit way to selenium driver congiguration
		// 1st step load the driver property inside JVM
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shitalc\\OneDrive - Maveric Systems Limited\\Desktop\\SeleniumDriver\\chromedriver-win64\\chromedriver.exe");

		// WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// option.addArgumwnts("--headless");
		options.addArguments("start-maxmized");
		options.addArguments("disable-infobars");
		options.setBinary(
				"C:\\Users\\shitalc\\OneDrive - Maveric Systems Limited\\Desktop\\SeleniumDriver\\chrome-win64\\chrome-win64\\chrome.exe");


		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}

}
