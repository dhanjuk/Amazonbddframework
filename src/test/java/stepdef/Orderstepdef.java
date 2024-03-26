package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Orderstepdef {
	WebDriver driver;
	@Given("User must be on hoepage")
	public void user_must_be_on_homepage() {
		System.setProperty("Webdriver.chrome.driver","Chromedriver.exe");
 		driver=new ChromeDriver();
 		driver.get("https://www.amazon.com/");
	}
	@When("After successfully login, and after clicking your order option")
	public void after_successfully_login_and_after_clicking_your_order_option() {
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		driver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
		driver.findElement(By.cssSelector("#ap_email")).sendKeys("singhsharanjeet748@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Dhanju28");	
		driver.findElement(By.name("rememberMe")).click();
		driver.findElement(By.id("signInSubmit")).click();
		Actions a1=new Actions(driver);
		a1.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).build().perform();
		driver.findElement(By.cssSelector("#nav-al-your-account > a:nth-child(2) > span")).click();
		driver.findElement(By.cssSelector("#a-page > div.a-container > div > div:nth-child(2) > div:nth-child(1) > a > div > div > div > div.a-column.a-span9.a-span-last > h2")).click();
	}
	@Then("Buy Again, Not Yet Shipped, Cancelled Order should be displayed")
	public void buy_again_not_yet_shipped_cancelled_order_should_be_displayed() {
		boolean b=driver.findElement(By.cssSelector("#a-page > section > div.your-orders-content-container__content.js-yo-main-content > "
				+ "div.a-section.a-spacing-medium.page-tabs > ul > li:nth-child(2) > a")).isDisplayed();
		System.out.println("Buy Again option is displayed: "+b);
		boolean n =driver.findElement(By.cssSelector("#a-page > section > div.your-orders-content-container__content.js-yo-main-content > div.a-section.a-spacing-medium.page-tabs > ul > li:nth-child(3) > a")).isDisplayed();
		System.out.println("Not Yet Shipped option is displayed: "+n);
		boolean c= driver.findElement(By.cssSelector("#a-page > section > div.your-orders-content-container__content.js-yo-main-content > div.a-section.a-spacing-medium.page-tabs > ul > li:nth-child(6) > a")).isDisplayed();
		System.out.println("Cancelled orders option is displayed: "+c);
	}

}
