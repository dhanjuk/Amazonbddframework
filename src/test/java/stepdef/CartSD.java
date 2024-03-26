package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSD {
    WebDriver ob;
	@Given("Customer should be on homepage and Sign in successfully after entering all required information")
	public void customer_should_be_on_homepage_and_sign_in_successfully_after_entering_all_required_information() {
		System.setProperty("Webdriver.chrome.driver","Chromedriver.exe");
 		ob=new ChromeDriver();
 		ob.get("https://www.amazon.com/");	
 		Actions a=new Actions(ob);
		a.moveToElement(ob.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		ob.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
		ob.findElement(By.cssSelector("#ap_email")).sendKeys("singhsharanjeet748@gmail.com");	
		ob.findElement(By.id("continue")).click();	
		ob.findElement(By.id("ap_password")).sendKeys("Dhanju28");	
		ob.findElement(By.name("rememberMe")).click();
		ob.findElement(By.id("signInSubmit")).click();	}
	@When("Search any item and add it into cart")
	public void search_any_item_and_add_it_into_cart() {
		ob.findElement(By.id("twotabsearchtextbox")).sendKeys("go go quinoa flour kirkland");
		ob.findElement(By.id("nav-search-submit-button")).click();
		ob.findElement(By.id("nav-cart-count")).click();
		String s1=ob.findElement(By.id("sc-subtotal-label-buybox")).getText();
		System.out.println("How many items are in cart before addng: "+ s1);
		ob.findElement(By.name("submit.addToCart")).click();
		ob.findElement(By.name("submit.addToCart")).click();	}
	@When("Proceed to checkout and enter invalid coupon")
	public void proceed_to_checkout_and_enter_invalid_coupon() throws InterruptedException {
		ob.findElement(By.name("proceedToRetailCheckout")).click();
		Thread.sleep(4000);
		ob.findElement(By.name("ppw-claimCode")).sendKeys("CMJ123"); //Invalid coupon
		ob.findElement(By.name("ppw-claimCodeApplyPressed")).click();
		Thread.sleep(2000);
		ob.findElement(By.cssSelector("#banner-image > span > span > i")).click();
		ob.findElement(By.id("a-autoid-1-announce")).click();
	}
	@When("delete item from cart")
	public void delete_item_from_cart() {
		ob.findElement(By.name("submit.delete.d1a60645-dbd3-4116-9382-50c19c844287")).click(); //delete one item
		System.out.println("One item is deleted");
	}
	@Then("Items should be added and delete")
	public void items_should_be_added_and_delete() {
		String s=ob.findElement(By.id("sc-subtotal-label-buybox")).getText();
		   System.out.println("How many items are in cart after addng: "+ s);  //compare before and after output

	}

}
