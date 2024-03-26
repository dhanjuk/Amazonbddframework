package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Signstepdef {

	WebDriver driver;
	@Given("User must be on homepage by clicking on url {string}")
	public void user_must_be_on_homepage_by_clicking_on_url(String string) {
		System.setProperty("Webdriver.chrome.driver","Chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(string);
	}
	@When("Use mouse houver on Accounts and list option")
	public void use_mouse_houver_on_accounts_and_list_option() {
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();		
	}
	@When("click on sign in button")
	public void click_on_sign_in_button() {
		driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
	}
	@When("after entering email or mobile number")
	public void after_entering_email_or_mobile_number() {
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("singhsharanjeet748@gmail.com");
	}
	@When("click on countinue")
	public void click_on_countinue() {
		driver.findElement(By.id("continue")).click();
	}
	@When("enter Password and click on remember me and Sign in button")
	public void enter_password_and_click_on_sign_in_button() {
		driver.findElement(By.id("ap_password")).sendKeys("Dhanju28");	
		driver.findElement(By.name("rememberMe")).click();
		driver.findElement(By.id("signInSubmit")).click();
	}
	@Then("User must be navigate to his or her account")
	public void user_must_be_navigate_to_his_or_her_account() throws InterruptedException {
	    String actual=driver.getCurrentUrl();
	    Assert.assertEquals("https://www.amazon.com/?ref_=nav_signin", actual);
	    System.out.println(actual);
	    Thread.sleep(2000);
	}
}
