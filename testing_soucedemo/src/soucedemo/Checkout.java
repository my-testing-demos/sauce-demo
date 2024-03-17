package soucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkout {
	public WebDriver driver;
	public WebDriver wait;
	
	@BeforeTest
	void startDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dinis\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}
	

	@Test(priority = 8)
	void emptyFirstName() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("last-name")).sendKeys("Erandi");
		driver.findElement(By.id("postal-code")).sendKeys("81400");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed());
	}
	
	@Test(priority = 9)
	void emptyLastName() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Dinishika");
		driver.findElement(By.id("postal-code")).sendKeys("81400");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed());
	}
	
	@Test(priority = 10)
	void emptyZipCode() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Dinishika");
		driver.findElement(By.id("last-name")).sendKeys("Erandi");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed());
	}
	
	@Test(priority = 11)
	void testCheckout() {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Dinishika");
		driver.findElement(By.id("last-name")).sendKeys("Erandi");
		driver.findElement(By.id("postal-code")).sendKeys("81400");
		driver.findElement(By.id("continue")).click();
		String expectedURL = "https://www.saucedemo.com/checkout-step-two.html";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
	}
	
	@Test(priority = 12)
	void finishiButton() {
		driver.findElement(By.id("finish")).click();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
		Assert.assertEquals(expectedURL, actualURL);
	}
	
	@Test(priority = 13)
	void backHomeButton() {
		driver.findElement(By.id("back-to-products")).click();
		String expectedURL = "https://www.saucedemo.com/inventory.html";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
	}
	
	@AfterTest
	void quitDriver() {
		driver.quit();
	}
}
