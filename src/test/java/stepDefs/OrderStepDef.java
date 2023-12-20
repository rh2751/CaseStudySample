package stepDefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductListPage;
import pages.PurchasePage;

public class OrderStepDef {
	WebDriver driver = TestBase.getDriver();
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	PurchasePage purchasePage;
	
	public OrderStepDef() {
		loginPage = new LoginPage(driver);
		listPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
		purchasePage = new PurchasePage(driver);
	}
	
	@Given("User is on login Page")
	public void user_is_on_login_page() {
		TestBase.openUrl("https://demoblaze.com/index.html");
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String strUser, String strPwd) throws InterruptedException {
		loginPage.loginIntoApp(strUser, strPwd);
	}
	@Then("User should be on Home page")
	public void user_should_be_on_home_page() throws InterruptedException {
		Assert.assertTrue(listPage.isLoggedIn());
	    System.out.println("Logged In Successful");
	}
	
//	@Given("User should be on Home page")
//	public void user_should_be_on_home_page() {
//	    
//	}
	@When("User add item to cart")
	public void user_add_item_to_cart() throws InterruptedException {
		listPage.addToCart();	    
	}
	@Then("Item must be added")
	public void item_must_be_added() throws InterruptedException {
		listPage.viewCart();	    
	}
	
	@When("Item should be present in cart")
	public void item_should_be_present_in_cart() throws InterruptedException {
	    listPage.viewCart();
	    Assert.assertTrue(cartPage.isItemAdded());
	}
	@Then("User delete item from cart")
	public void user_delete_item_from_cart() throws InterruptedException {
		TestBase.manualWait();
		Thread.sleep(2000);
		cartPage.delFromCart();
	}
	
	@Given("User is on cart page")
	public void user_is_on_cart_page() throws InterruptedException {
	    listPage.viewCart();
	    Assert.assertTrue(cartPage.isItemAdded());
	}
	@When("User do Purchase")
	public void user_do_purchase() throws InterruptedException {
		purchasePage.submitInfo("TestUser", "IND", "MUM", "234567", "23", "12");   
	}
	@Then("Should navigate to Purchase page")
	public void should_navigate_to_purchase_page() throws InterruptedException {
	    purchasePage.orderComplete();
	    purchasePage.submitOrder();
	}

}
