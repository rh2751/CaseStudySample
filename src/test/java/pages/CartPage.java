package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(xpath = "//div//table//tr//td[contains(text(), 'Samsung galaxy s6')]")
	WebElement cartList;
	
	@FindBy(xpath = "(//a[text()='Delete'])[2]")
	WebElement rmvItemTwo;
	
	//Actions
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//verify element is added
	public boolean isItemAdded() throws InterruptedException {
		Thread.sleep(2000);
		return cartList.isDisplayed();
	}
	
	//remove item
	public void delFromCart() {
		rmvItemTwo.click();
	}

}