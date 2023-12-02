
package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	@FindBy(xpath="(//*[@class='icon icon-search'])[3]")
	private WebElement searchIcon;
	@FindBy(xpath="(//*[@class='icon icon-search'])[3]/parent::form/child::input")
	private WebElement searchTextBox;
	@FindBy(xpath="//div[@class='list-view-item__title']/child::a")
	private List<WebElement> productList;
	@FindBy(xpath="//h1[@class='product-single__title']")
	private WebElement productTitle;
	@FindBy(xpath="//button[@name='add']")
	private WebElement addToCart;
	@FindBy(xpath="//a[text()='Remove']")
	private WebElement removeLink;
	@FindBy(xpath="//input[@name='update']")
	private WebElement updateButton;
	@FindBy(xpath="//a[@href='/cart']")
	private WebElement cartButton;
	@FindBy(xpath="//p[text()='Your cart is currently empty.']")
	private WebElement emptyCart;
	
	public void clickSearchIcon() {
		try {
			   Thread.sleep(5000);
				searchIcon.click();
		}catch(Exception e) {
			Assert.fail("Search Icon is not displayed");
		}
	}
	
	public void searchProduct(String product) {
		try {
			if(searchTextBox.isDisplayed()) {
				Thread.sleep(5000);
				searchTextBox.sendKeys(product);
			}
		}catch(Exception e) {
			Assert.fail("Search Icon is not displayed");
		}
	}
	
	public boolean verifyProduct() {
		boolean flag=false;
		try {
			if(productList.size()>0) {
				Thread.sleep(5000);
				productList.get(0).click();
				flag=true;
			}
		}catch(Exception e) {
			return false;
		}
		return flag;
	}
	
	public boolean clickAdd() {
		boolean flag=false;
		try {
			if(addToCart.isDisplayed()) {
				Thread.sleep(5000);
				addToCart.click();
				if(removeLink.isDisplayed()) {
					flag=true;
				}
				
			}
		}catch(Exception e) {
			return false;
		}
		return flag;
	}
	
	public boolean clickRemove() {
		boolean flag=false;
		try {
			if(removeLink.isDisplayed()) {
				Thread.sleep(5000);
				addToCart.click();
				if(emptyCart.isDisplayed()) {
					flag=true;
				}
				
			}
		}catch(Exception e) {
			return false;
		}
		return flag;
	}
	
	public boolean clickupdate() {
		boolean flag=false;
		try {
			if(updateButton.isDisplayed()) {
				Thread.sleep(5000);
				updateButton.click();
					flag=true;
			}
		}catch(Exception e) {
			return false;
		}
		return flag;
	}
	
	
}