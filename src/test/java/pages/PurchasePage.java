package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
	
	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement chkoutBtn;
	
	@FindBy(id = "name")
	WebElement name;
	
	@FindBy(id = "country")
	WebElement country;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "card")
	WebElement creditCard;
	
	@FindBy(id = "month")
	WebElement month;
	
	@FindBy(id = "year")
	WebElement year;
	
	@FindBy(xpath = "//button[text()='Purchase']")
	WebElement purchaseBtn;
	
	@FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
	WebElement successMsg;
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement finBtn;
	
	//Actions
	public PurchasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//enter & submit info
	public void submitInfo(String Cname, String Ccountry, String Ccity, String Ccard, String Cyear, String Cmonth) throws InterruptedException {
		Thread.sleep(2000);
		chkoutBtn.click();
		Thread.sleep(2000);
		name.sendKeys(Cname);
		Thread.sleep(2000);
		country.sendKeys(Ccountry);
		Thread.sleep(2000);
		city.sendKeys(Ccity);
		Thread.sleep(2000);
		creditCard.sendKeys(Ccard);
		Thread.sleep(2000);
		year.sendKeys(Cyear);
		Thread.sleep(2000);
		month.sendKeys(Cmonth);
		Thread.sleep(2000);
		purchaseBtn.click();
	}
	
	//verify order complete
	public boolean orderComplete() {
		return successMsg.isDisplayed();
	}

	//complete order
	public void submitOrder() throws InterruptedException {
		Thread.sleep(2000);
		finBtn.click();
	}

}
