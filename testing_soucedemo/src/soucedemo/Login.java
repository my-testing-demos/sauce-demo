package soucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login {

	public WebDriver driver;
	
	@BeforeTest
	void startDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\dinis\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority = 3)
	void correctNameAndPassword() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		String expected = "https://www.saucedemo.com/inventory.html";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(expected, actual);
	}
	
	@Test(priority = 2)
	void incorrectPassword(){
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sause");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		String expected = "https://www.saucedemo.com/inventory.html";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(expected, actual);
	}
	
	@Test(priority = 1)
	void incorrectName() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("new_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		String expected = "https://www.saucedemo.com/inventory.html";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(expected, actual);
	}
	
	@Test(priority =4)
	void logout() {
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
		String expected = "https://www.saucedemo.com/";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(expected, actual);
	}
	
	@AfterTest
	void quitDriver() {
		driver.quit();
	}
	
}

