package com.sddevops.DevOpsProj2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DevOpsProj2Test {
	private WebDriver webDriver;
	
	@Test
	public void checkTitle() {

		webDriver.navigate().to("http://localhost:8090/DevOpsProj2/");

		// Assert the title to check that we are indeed in the correct website
		Assert.assertEquals(webDriver.getTitle(), "Worker-Registration");
		System.out.println("title: " + webDriver.getTitle());
	}

	@Test
	public void checkButton() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/DevOpsProj2/");

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.className("link")).click();

		// Assert the new title to check that the title contain Employee Management and
		// the button had successfully bring us to the new page
		Assert.assertTrue(webDriver.getTitle().contains("Employee Management"));
		System.out.println("new title: " + webDriver.getTitle());
	}

	@Test
	public void addEmployee() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/DevOpsProj2/");

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.name("name")).sendKeys("Auto");

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.name("date")).sendKeys("15/01/2003");

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.name("gender")).click();

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.name("role")).sendKeys("Worker");

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.name("type")).click();

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.className("button")).click();
	}

	@Test
	public void EditEmployeeDetails() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8090/DevOpsProj2/");

		webDriver.findElement(By.className("link")).click();
		webDriver.findElement(By.className("edit")).click();

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.name("phone")).sendKeys("94658343");

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.name("email")).sendKeys("autoEdit@email.com");

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.name("save")).click();

	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
