package testCases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.GiftCard;
import testBase.TestBase;
@Listeners(testCases.ExtentReport.class)

public class TC_05_giftCard extends TestBase {
	
	public GiftCard gc;
	
	@Test(priority=11,groups={"smoke"})
	public void user_clicks_on_gift_cards() throws InterruptedException {
		gc=new GiftCard(driver);
		Actions action = new Actions(driver);
		action.keyUp(Keys.PAGE_UP).perform();
		gc.openGiftCards();
		Thread.sleep(3000);
	    gc.scrollPage();
	    
	}

	@Test(priority=12,groups={"regression"})
	public void chooses_birthday_or_anniversary() throws InterruptedException {
		Thread.sleep(5000);
	
	    gc.selectCard();
	   
	}

	@Test(priority=13,groups={"regression"})
	public void enters_the_valid_amount_month_and_date() throws InterruptedException, IOException {
		Thread.sleep(3000);
	   gc.selectAmnt();
	   gc.selectMonth();
	   gc.selectdate();
	   
	}

	@Test(priority=14,groups={"smoke"})
	public void clicks_on_the_next_button() throws InterruptedException {
		Thread.sleep(3000);
	    gc.selectNext();
	   
	}

	@Test(priority=15,groups={"regression","smoke"})
	public void fills_to_from_details() throws InterruptedException, IOException {
		Thread.sleep(3000);
	   gc.setRName();
	   gc.setREmail();
	   gc.setRPhn();
	   gc.setSName();
	   gc.setSEmail();
	   gc.setSPhn();
	   gc.setAdd();
	   gc.setPin();
	   
	   
	}


}
