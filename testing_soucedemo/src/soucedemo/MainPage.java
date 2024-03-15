package soucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPage {
	
	public WebDriver driver;
	
	@BeforeTest
	void startDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dinis\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	void addToCart() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.xpath("//div[@class='inventory_item_name']")).click();
		String actualName = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
		String expectedName = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText();
		System.out.println(expectedName);
		System.out.println(actualName);
		Assert.assertEquals(expectedName, actualName);
	}
	
	@AfterTest
	void quitDriver() {
		driver.quit();
	}

}
