package soucedemo;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider
	public Object[][] loginDataset(){
		return new Object[][] {
			{"standard_user", "secret_sauce"},
			{"problem_user", "secret_sauce"},
			{"performance_glitch_user", "secret_sauce"},
			{"error_user", "secret_sauce"},
			{"visual_user", "secret_sauce"}
		};
	}

	@DataProvider
	public Object[][] productDataset(){
		return new Object[][] {
			{"//div[normalize-space()='Sauce Labs Backpack']", "https://www.saucedemo.com/inventory-item.html?id=4"},
			{"//div[normalize-space()='Sauce Labs Bike Light']", "https://www.saucedemo.com/inventory-item.html?id=0"},
			{"//div[normalize-space()='Sauce Labs Bolt T-Shirt']", "https://www.saucedemo.com/inventory-item.html?id=1"},
			{"//div[normalize-space()='Sauce Labs Fleece Jacket']", "https://www.saucedemo.com/inventory-item.html?id=5"},
			{"//div[normalize-space()='Sauce Labs Onesie']", "https://www.saucedemo.com/inventory-item.html?id=2"},
			{"//div[normalize-space()='Test.allTheThings() T-Shirt (Red)']", "https://www.saucedemo.com/inventory-item.html?id=3"}
		};
	}
	
	@DataProvider
	public Object[][] removeButtonDataset(){
		return new Object[][] {
			{"add-to-cart-sauce-labs-backpack", "remove-sauce-labs-backpack"},
			{"add-to-cart-sauce-labs-bike-light", "remove-sauce-labs-bike-light"},
			{"add-to-cart-sauce-labs-bolt-t-shirt", "remove-sauce-labs-bolt-t-shirt"},
			{"add-to-cart-sauce-labs-fleece-jacket", "remove-sauce-labs-fleece-jacket"},
			{"add-to-cart-sauce-labs-onesie", "remove-sauce-labs-onesie"},
			{"add-to-cart-test.allthethings()-t-shirt-(red)", "remove-test.allthethings()-t-shirt-(red)"}
		};
	}
	
	@DataProvider
	public Object[][] socialMediaDataset(){
		return new Object[][] {
			{"//a[normalize-space()='Twitter']", "https://twitter.com/saucelabs"},
			{"//a[normalize-space()='Facebook']", "https://www.facebook.com/saucelabs"},
			{"//a[normalize-space()='LinkedIn']", "https://www.linkedin.com/company/sauce-labs/"}
		};
	}
	
	@DataProvider
	public Object[][] checkoutDataset(){
		return new Object[][] {
			{"", "Erandi", "81400"},
			{"Dinishika", "", "81400"},
			{"Dinishika", "Erandi", ""}
		};
	}
	
	@DataProvider(name = "dropDownList")
	public Object[][] dataset1(Method m){
		Object[][] testdata = null;
		
		if (m.getName().equals("sortDropdown"))
		{
		testdata = new Object[][]
			{
				{"Name (A to Z)"},
				{"Name (Z to A)"},
				{"Price (high to low)"},
				{"Price (low to high)"}
			};
		}
		
		else if(m.getName().equals("checkSort"))
		{
		testdata = new Object[][]
			{
				{"Name (A to Z)", "$29.99"},
				{"Name (Z to A)", "$15.99"},
				{"Price (high to low)", "$49.99"},
				{"Price (low to high)", "$7.99"}
			};
		}
		return testdata;
	}
}
