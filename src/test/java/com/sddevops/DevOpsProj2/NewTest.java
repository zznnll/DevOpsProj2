package com.sddevops.DevOpsProj2;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	//declare Selenium WebDriver
	  private WebDriver webDriver;	
	  
	  
  @Test
  public void checkTitle() {
	  
	  webDriver.navigate().to("http://localhost:8090/DevOpsProj2/");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "Worker-Registration");
	  System.out.println("title: "+webDriver.getTitle());  
  }
  
  @Test
  public void checkButton() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8090/DevOpsProj2/");
	  
	//Retrieve link using it's class name and click on it
	  webDriver.findElement(By.className("link")).click();

	  //Assert the new title to check that the title contain Employee Management and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("Employee Management"));
	  System.out.println("new title: "+webDriver.getTitle());
  }	  
  
  

  @BeforeTest
  public void beforeTest() {
	//Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Users\\65929\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver(); 
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.quit();			
  }

}
