package com.sddevops.DevOpsProj2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DevOpsProj2Test {
	private WebDriver webDriver;
	

	@BeforeTest
	public void beforeTest() {
		
		String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("disable-infobars");
		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
		webDriver = new ChromeDriver(chromeOptions);
		

	}

	@AfterTest
	public void afterTest() {
		webDriver.quit();
	}

}
