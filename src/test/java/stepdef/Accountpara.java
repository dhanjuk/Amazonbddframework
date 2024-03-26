package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
public class Accountpara {
     WebDriver ob;
	@Given("Must be on homepage and open create new account page")
	public void must_be_on_homepage_and_open_create_new_account_page() {
		System.setProperty("Webdriver.chrome.driver","Chromedriver.exe");
 		ob=new ChromeDriver();
 		ob.get("https://www.amazon.com/");
		Actions a1=new Actions(ob);
		a1.moveToElement(ob.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		ob.findElement(By.linkText("Start here.")).click();
	}

	@When("^enter (.*) and (.*) and (.*) and (.*)$")
	public void enter_your_name_and_email_and_password_and_re_enter_password(String YourName, String Email, String Password, String ReenterPassword) {
		ob.findElement(By.id("ap_customer_name")).sendKeys(YourName);
		ob.findElement(By.id("ap_email")).sendKeys(Email);
		ob.findElement(By.id("ap_password")).sendKeys(Password);
		ob.findElement(By.id("ap_password_check")).sendKeys(ReenterPassword);			
	}

	@When("click on continue button")
	public void click_on_continue_button() throws InterruptedException {
		ob.findElement(By.id("continue")).click();
		Thread.sleep(2000);
	}

	@Then("User should be on Enter OTP page")
	public void user_should_be_on_enter_otp_page() {
	    String s=ob.getCurrentUrl();
	    System.out.println(s);
	   
}
}