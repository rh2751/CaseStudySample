package stepDefs;

import org.openqa.selenium.WebDriver;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductListPage;

public class OrderStepDef {
	WebDriver driver = TestBase.getDriver();
	LoginPage loginPage;
	ProductListPage listPage;
	
	public OrderStepDef() {
		loginPage = new LoginPage(driver);
		listPage = new ProductListPage(driver);
	}
	
	@Given("User is on login Page")
	public void user_is_on_login_page() {
		TestBase.openUrl("https://demoblaze.com/index.html");
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String strUser, String strPwd) {
		loginPage.loginIntoApp(strUser, strPwd);
	}
	@Then("User should be on Home page")
	public void user_should_be_on_home_page() {
		listPage.isLoggedIn();
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
	public void item_must_be_added() {
		listPage.viewCart();	    
	}
	
	@When("Item should be present in cart")
	public void item_should_be_present_in_cart() {
	    
	}
	@Then("User delete item from cart")
	public void user_delete_item_from_cart() {
		
	}

}
