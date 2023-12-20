package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ProductListPage {
	
	@FindBy(xpath = "//a[text()='Samsung galaxy s6']")
	WebElement itemOne;
	
	@FindBy(xpath = "//a[text()='Nokia lumia 1520']")
	WebElement itemTwo;
	
	@FindBy(xpath = "//a[text()='Add to cart']")
	WebElement addToCart;
	
	@FindBy(xpath = "//a[text()='Home ']")
	WebElement homePage;
	
	@FindBy(xpath = "//a[text()='Cart']")
	WebElement cartPage;
	
	@FindBy(xpath = "//a[@id='nameofuser']")
	WebElement userTitle;
	
	//Actions
	public ProductListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//add to cart
	public void addToCart() throws InterruptedException {
		//item 1
		TestBase.manualWait();
		Thread.sleep(2000);
		itemOne.click();
		TestBase.manualWait();
		addToCart.click();
		TestBase.manualWait();
		Thread.sleep(2000);
		TestBase.confirmBox();
		homePage.click();
		
		//item 2
		TestBase.manualWait();
		Thread.sleep(2000);
		itemTwo.click();
		TestBase.manualWait();
		addToCart.click();
		TestBase.manualWait();
		Thread.sleep(2000);
		TestBase.confirmBox();
		homePage.click();
		TestBase.manualWait();
	}
	
	//view cart
	public void viewCart() {
		cartPage.click();
	}
	
	//verify on checkout page
	public boolean isLoggedIn() {
		return userTitle.isDisplayed();
	}

}