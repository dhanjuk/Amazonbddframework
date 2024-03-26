package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class AddressSD {
     WebDriver ob;
     @Given("User must be on homepage")
     public void user_must_be_on_homepage() {
    	 System.setProperty("Webdriver.chrome.driver","Chromedriver.exe");
 		ob=new ChromeDriver();
 		ob.get("https://www.amazon.com/");
     }
	@Given("should be on add address option after successfully sign in")
	public void should_be_on_add_address_option_after_successfully_sign_in() {
		
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
		  ob.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(2) > span")).click(); 
		  ob.findElement(By.cssSelector("#a-page > div.a-container > div > div:nth-child(3) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > div > span")).click();
		  ob.findElement(By.cssSelector("#ya-myab-plus-address-icon")).click();
	}
	@When("User enters all the required information")
	public void user_enters_all_the_required_information() throws InterruptedException {
		  ob.findElement(By.cssSelector("#address-ui-widgets-countryCode > span > span")).click();
		  ob.findElement(By.id("address-ui-widgets-countryCode-dropdown-nativeId_39")).click(); Thread.sleep(3000);
		  ob.findElement(By.cssSelector("#address-ui-widgets-enterAddressFullName")).sendKeys("Jatinder");
		  ob.findElement(By.cssSelector("#address-ui-widgets-enterAddressPhoneNumber")).sendKeys("1234566789");
		  ob.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("7287 shallford rd");
		  ob.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Mississauga"); 
		  ob.findElement(By.cssSelector("#address-ui-widgets-enterAddressStateOrRegion > span > span")).click(); 
		  ob.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8")).click();
		  ob.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("L4T 2P8");
		  ob.findElement(By.id("address-ui-widgets-use-as-my-default")).click();
		  Thread.sleep(3000);
		  ob.findElement(By.id("address-ui-widgets-addr-details-gate-code")).sendKeys("12345"); 
		  Thread.sleep(3000); 
		  ob.findElement(By.xpath("//*[@id=\"address-ui-widgets-addr-details-business-hours\"]/span/span")).click(); 
		  ob.findElement(By.id("dropdown1_1")).click(); 
		 
	}

	@When("click on Add Address button")
	public void click_on_add_address_button() {
		 ob.findElement(By.cssSelector("#address-ui-widgets-form-submit-button > span > input")).click();
	}

	@Then("Address should be added")
	public void address_should_be_added() {
		boolean b= ob.findElement(By.id("ya-myab-display-address-block-0")).isDisplayed();
		System.out.println("address is added: "+b);
}
}