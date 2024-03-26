package stepdef;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
public class Loginstepdef {    
	WebDriver ob;
	@Given("User should be on homepage")
	public void user_should_be_on_homepage() {
		System.setProperty("Webdriver.chrome.driver","Chromedriver.exe");
 		ob=new ChromeDriver();
 		ob.get("https://www.amazon.com/");
	}
	@When("After successfully login, and after clicking your Login and security option")
	public void after_successfully_login_and_after_clicking_your_login_and_security_option() {
		Actions a=new Actions(ob);
		a.moveToElement(ob.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		ob.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
		ob.findElement(By.cssSelector("#ap_email")).sendKeys("singhsharanjeet748@gmail.com");	
		ob.findElement(By.id("continue")).click();	
		ob.findElement(By.id("ap_password")).sendKeys("Dhanju28");	
		ob.findElement(By.name("rememberMe")).click();
		ob.findElement(By.id("signInSubmit")).click();
		  Actions a1=new Actions(ob);
		  a1.moveToElement(ob.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		  ob.findElement(By.linkText("Account")).click();
		  ob.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[2]/div[2]/a/div/div/div/div[2]/div/span")).click();
	}
	@When("update name")
	public void update_name() {
		ob.findElement(By.cssSelector("#NAME_BUTTON > span > a")).click();
		ob.findElement(By.id("ap_customer_name")).clear();
		ob.findElement(By.id("ap_customer_name")).sendKeys("Jatinder");
		ob.findElement(By.id("cnep_1C_submit_button")).click();
	}
	@Then("Name should be updated")
	public void name_should_be_updated() throws InterruptedException {	  
		String s=ob.findElement(By.cssSelector("#SUCCESS_MESSAGES > div > div")).getText();
		System.out.println("Message after updating name: " +s);
	    Assert.assertEquals("Name updated.", s);
	}	
}
