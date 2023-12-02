package org.FrameWork;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.HomePage;

public class SampleTestNG{
	WebDriver driver;
	HomePage home;
	@BeforeClass
	public void BeforeClass() {
	driver=new ChromeDriver();
	home=new HomePage();
	driver.manage().window().maximize();
	}
	
	@Parameters({"Product"})
	@Test
	public void test1(String product) {
		driver.get("https://adnabu-arjun.myshopify.com");
		//home.clickSearchIcon();
		home.searchProduct(product);
		home.clickSearchIcon();
		Assert.assertTrue(home.verifyProduct());
		
	}
	
	@Test
	public void test2(String product) {
		driver.get("https://adnabu-arjun.myshopify.com");
		home.clickSearchIcon();
		home.searchProduct(product);
		home.clickSearchIcon();
		Assert.assertTrue(home.verifyProduct());
		Assert.assertTrue(home.clickAdd());
		Assert.assertTrue(home.clickupdate());	
	}
	
	@Test
	public void test3(String product) {
		driver.get("https://adnabu-arjun.myshopify.com");
		home.clickSearchIcon();
		home.searchProduct(product);
		home.clickSearchIcon();
		Assert.assertTrue(home.verifyProduct());
		Assert.assertTrue(home.clickAdd());
		Assert.assertTrue(home.clickRemove());
		
	}
	
	@AfterClass
	public void AfterClass() {
	driver.quit();
	}
	

}
