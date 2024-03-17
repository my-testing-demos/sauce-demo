package soucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cart {
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
	
	@Test(priority = 1)
	void cartButton() {
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		String expectedURL = "https://www.saucedemo.com/cart.html";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL,  actualURL);
	}
	
	@Test(priority = 2)
	void addToCart() {
		driver.findElement(By.id("continue-shopping")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		String actualName = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		String expectedName = driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).getText();
		Assert.assertEquals(expectedName, actualName);
	}
	
	@Test(priority = 3)
	void removeButtonInCart() {
		WebElement removeButton = driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']"));
		removeButton.click();
		driver.findElement(By.id("continue-shopping")).click();
		Assert.assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed());
	}
	
	@Test(priority = 4)
	void removeButtonInMain() {
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
		removeButton.click();
		Assert.assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed());
	}
	
	@Test(priority = 14)
	void productDetails() {
		driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Bolt T-Shirt']")).click();
		String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=1";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
	}
	
	@Test(priority = 15)
	void backToProduts() {
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
