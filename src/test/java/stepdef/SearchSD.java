package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
public class SearchSD {
	WebDriver ob;
	@Given("User must be on homwpage")
	public void user_must_be_on_homwpage() {
		System.setProperty("Webdriver.chrome.driver","Chromedriver.exe");
 		ob=new ChromeDriver();
 		ob.get("https://www.amazon.com/");	}
	@When("Sign in successfully after entering all required information")
	public void sign_in_successfully_after_entering_all_required_information() {
		Actions a=new Actions(ob);
		a.moveToElement(ob.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		ob.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
		ob.findElement(By.cssSelector("#ap_email")).sendKeys("singhsharanjeet748@gmail.com");	
		ob.findElement(By.id("continue")).click();	
		ob.findElement(By.id("ap_password")).sendKeys("Dhanju28");	
		ob.findElement(By.name("rememberMe")).click();
		ob.findElement(By.id("signInSubmit")).click();
	}
	@When("Search something in search field and click on search button")
	public void search_something_in_search_field_and_click_on_search_button() throws InterruptedException {
		ob.findElement(By.id("twotabsearchtextbox")).sendKeys("t- shirts for women");
		ob.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);	}
	@When("perform sorting and filteration")
	public void perform_sorting_and_filteration() throws InterruptedException {
		ob.findElement(By.cssSelector("#a-autoid-0-announce > span.a-dropdown-prompt")).click(); //sorting by newest arrival
		ob.findElement(By.id("s-result-sort-select_4")).click();
		Thread.sleep(3000);
		ob.findElement(By.cssSelector("#p_36\\/2661613011 > span > a > span")).click(); //Filtering by price
		Thread.sleep(3000);
        ob.findElement(By.cssSelector("#p_n_date_first_available_absolute\\/15196852011 > span > a > span")).click();//last 30 days
	}
	@Then("Results should be displayed")
	public void results_should_be_displayed() {
		String s=ob.findElement(By.cssSelector("#a-autoid-0-announce > span.a-dropdown-prompt")).getText();
		System.out.println("Resulted option of sorting: "+ s);		
		boolean b=ob.findElement(By.cssSelector("#p_36\\/2661613011 > span > a > span")).isEnabled();
		System.out.println("Is Filtering by price enabled:"+b);
		boolean c=ob.findElement(By.cssSelector("#p_n_date_first_available_absolute\\/15196852011 > span > a > span")).isEnabled();
		System.out.println("Is last 30 days enabled: "+c);

	}
}
