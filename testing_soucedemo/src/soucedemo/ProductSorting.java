package soucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductSorting {
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
	@Test(priority = 5)
	void sortDropdown() throws InterruptedException {
		Select obj = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		obj.selectByVisibleText("Name (Z to A)");
		Thread.sleep(2000);
		String actualName = driver.findElement(By.xpath("//span[@class='active_option']")).getText();
		String expectedName = "Name (Z to A)";
		Assert.assertEquals(expectedName, actualName);
	}
	
	@Test(priority = 6)
	void sortPriceLowtoHigh() throws InterruptedException {
		Select obj = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		obj.selectByVisibleText("Price (low to high)");
		Thread.sleep(2000);
		String actualName = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText();
		String expectedName = "$7.99";
		Assert.assertEquals(expectedName, actualName);
	}
	
	@Test(priority = 7)
	void sortPriceHightoLow() throws InterruptedException {
		Select obj = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		obj.selectByVisibleText("Price (high to low)");
		Thread.sleep(2000);
		String actualName = driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText();
		String expectedName = "$49.99";
		Assert.assertEquals(expectedName, actualName);
	}
	@AfterTest
	void quitDriver() {
		driver.quit();
	}
}
