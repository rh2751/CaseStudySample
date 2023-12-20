package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage {
	
	@FindBy(xpath = "//a[@id = 'login2']")
	WebElement logIn;
	
	@FindBy(id = "loginusername")
	WebElement userId;
	
	@FindBy(id = "loginpassword")
	WebElement pwd;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public void loginIntoApp(String strUser,String strPwd) throws InterruptedException {
		logIn.click();
		TestBase.manualWait();
		Thread.sleep(1000);
		userId.sendKeys(strUser);
		TestBase.manualWait();
		Thread.sleep(1000);
		pwd.sendKeys(strPwd);
		TestBase.manualWait();
		Thread.sleep(1000);
		loginBtn.click();
	}

}