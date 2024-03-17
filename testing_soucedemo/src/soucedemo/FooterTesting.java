package soucedemo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FooterTesting {
	
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
	void linkTwitter()throws InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Twitter']")).click();
		String expectedURL = "https://twitter.com/saucelabs";
		Thread.sleep(2000);
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(windowHandles.iterator().next());
	}

	@Test(priority = 2)
	void linkFacebook()throws InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='Facebook']")).click();
		String expectedURL = "https://www.facebook.com/saucelabs";
		Thread.sleep(2000);
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(windowHandles.iterator().next());
	}
	
	@Test(priority = 3)
	void linkLinkedIn()throws InterruptedException {
		driver.findElement(By.xpath("//a[normalize-space()='LinkedIn']")).click();
		String expectedURL = "https://www.linkedin.com/company/sauce-labs/";
		Thread.sleep(2000);
        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		driver.close();
		Thread.sleep(5000);
		driver.switchTo().window(windowHandles.iterator().next());
	}
	
	@AfterTest
	void quitDriver() {
		driver.quit();
	}
}
