package SetupClass.TestStep;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class sign_up_correct_data extends Set {
	WebDriverWait wait = new WebDriverWait(driver,8);
       JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on sign up page cd$")
	public void user_is_already_on_sign_up_page_cd() throws InterruptedException  {
	    
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
	    Thread.sleep(2000);
	    try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
	    Thread.sleep(3000);
		try {
			driver.findElement(By.cssSelector("ul.header > li:nth-child(1) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL and redirect user to sign up page");
		} 
		catch (NoSuchElementException popup) {
		}
	}

	@Then("^enter new email to sign up cd$")
	public void enter_new_email_to_sign_up_cd() throws InterruptedException  {
	    
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    System.out.println(generatedString);
	    
	    String signup_email=generatedString;
	    String full_email="selenium.testing."+generatedString+"@gmail.com";
	    System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		//driver.findElement(By.id("email_address")).sendKeys(full_email);
		

		Thread.sleep(2000);
	    WebElement new_email_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("email_address")));
		Thread.sleep(2000);
	    new_email_signup.sendKeys(full_email);
		Thread.sleep(2000);
	}

	@Then("^User enter firstname and lastname to sign up cd$")
	public void user_enter_firstname_and_lastname_to_sign_up_cd() throws InterruptedException  {
	    

	    WebElement new_fname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname")));
		Thread.sleep(2000);
	    new_fname_signup.sendKeys("Selenium");
		Thread.sleep(2000);

	    WebElement new_lname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("lastname")));
		Thread.sleep(2000);
	    new_lname_signup.sendKeys("Testing");
		Thread.sleep(2000);
	}

	@Then("^user enter password and confirm password to sign up cd$")
	public void user_enter_password_and_confirm_password_to_sign_up_cd() throws InterruptedException  {
	    
		 WebElement new_pwd_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
			Thread.sleep(2000);
		    new_pwd_signup.sendKeys("selenium@123");
			Thread.sleep(2000);

		    WebElement new_pwd1_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password-confirmation")));
			Thread.sleep(2000);
		    new_pwd1_signup.sendKeys("selenium@123");
			Thread.sleep(2000);
	}

	@Then("^user enter captcha to sign up cd$")
	public void user_enter_captcha_to_sign_up_cd() throws InterruptedException  {
	    
		WebElement new_captcha_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_user_create")));
		Thread.sleep(2000);
	    new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");
		
	}

	@Then("^check checkbox to sign up cd$")
	public void check_checkbox_to_sign_up_cd() throws InterruptedException  {
	    
		/*
		 * WebElement new_checkbox_signup =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
		 * ".iCheck-helper"))); Thread.sleep(2000); new_checkbox_signup.click();
		 */
		Thread.sleep(2000);
	}

	@Then("^user click on sign up button to sign up cd$")
	public void user_click_on_sign_up_button_to_sign_up_cd() throws InterruptedException  {
	    
		WebElement new_btn_signup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".submit")));
		Thread.sleep(2000);
	    new_btn_signup.click();
		Thread.sleep(2000);
	   
	}

	@Then("^user lands on pricing page and then user go to free ppts page cd$")
	public void user_lands_on_pricing_page_and_then_user_go_to_free_ppts_page_cd() throws InterruptedException  {
		
		Thread.sleep(1000);
		WebElement Popular_ppt= driver.findElement(By.xpath("//*[@id="html-body"]/div[2]/header/div[1]/div[2]/div/nav/div/div/ul/li[3]/a"));
	     Thread.sleep(1000);
		Popular_ppt.click();
	
		Thread.sleep(2000);
		WebElement Popular_product= driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[4]/div[2]/ol/li[2]/div/a/img"));
		Thread.sleep(3000);
		Popular_product.click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#clicking")).click();
		Thread.sleep(8000);
		
		
		js.executeScript("window.scrollBy(0,1000)");
		 WebElement join_now_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(.,'Join now')])[8]")));
			Thread.sleep(2000);
		    join_now_btn.click();
			Thread.sleep(6000);
		
	}

	@Then("^user download a free product cd$")
	public void user_download_a_free_product_cd() throws InterruptedException  {
		/*try
		{
			WebElement cp_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='paypal_express']")));
			Thread.sleep(2000);
		    cp_btn.click();
		    Thread.sleep(3000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}*/
		  Thread.sleep(3000);
		try
		{
			  WebElement place_order_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Place Order')]")));
			js.executeScript("arguments[0].scrollIntoView();",place_order_btn);	
			Thread.sleep(3000);
		          place_order_btn.click();
			  Thread.sleep(5000);
		}
		 catch (Exception e) {
			 //TODO: handle exception	 
	        } 
		
		  Thread.sleep(3000);
	    // Maximize Window
		  driver.manage().window().maximize();
		
		  // Store the CurrentWindow for future reference
		 // String handle = " ";
		  String currentWindow = driver.getWindowHandle();
		  String popupWindowHandle = null;
		   
		  // Switch To Popup Window
		  
		  for(String handle : driver.getWindowHandles()){
		   if(!handle.equals(currentWindow)){
		    
		    popupWindowHandle = handle;
		     driver.switchTo().window(popupWindowHandle);
		   }
		  }
		  
		 
		  
		// page title
		  String pp_page_title=driver.getTitle();
			Thread.sleep(3000);
		    System.out.println("Title of the Page is --> "+pp_page_title);
		    
		 // place order button 
			// WebElement cancel_order_btn  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(.,'Cancel and return to Slideteam Pte. Ltd.')])[2]")));
			//	js.executeScript("arguments[0].scrollIntoView();",cancel_order_btn);
		//Thread.sleep(2000);
		//	    cancel_order_btn.click();
		//		Thread.sleep(5000);

				 // Switch To Default Window
		driver.get("https://www.slideteam.net/checkout/");
		Thread.sleep(2000);		  
				  driver.switchTo().window(currentWindow);
	}

	@Then("^user delete the new account created cd$")
	public void user_delete_the_new_account_created_cd() throws InterruptedException  {
       Thread.sleep(3000);

		
		// WebElement account = driver.findElement(By.xpath("//a[contains(.,'My Account')]"));
			  Thread.sleep(3000);
			//account.click();
		driver.get("https://www.slideteam.net/customer/account/");
		 Thread.sleep(3000);
		 
		

		 WebElement delete_account = driver.findElement(By.cssSelector("#clicking"));
		js.executeScript("arguments[0].scrollIntoView();",delete_account);
		 delete_account.click();
		 Thread.sleep(3000);
		WebElement delete_reason = driver.findElement(By.cssSelector("#exampleRadios1"));
		Thread.sleep(3000);
		delete_reason.click();
		Thread.sleep(3000);
		
		 WebElement delete_profile = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#delete-final")));
		js.executeScript("arguments[0].scrollIntoView();",delete_profile);
		delete_profile.click();
		 Thread.sleep(3000);
		
		WebElement delete_profile_coupon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#flipModal > div > div > div.modal-footer.button_action > button.btn.btn-default.button_2")));
		js.executeScript("arguments[0].scrollIntoView();",delete_profile_coupon);
		delete_profile_coupon.click();
		 Thread.sleep(3000);
	}
	
	
}
