package testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.GiftCard;
import testBase.TestBase;
@Listeners(testCases.ExtentReport.class)

public class TC_06_validation extends TestBase {
	
	public GiftCard gc;
	
	@Test(priority=16,groups={"regression"})
	public void validate_the_email_id() throws InterruptedException, IOException {
		gc=new GiftCard(driver);
		gc.clickCnfrmBtn();
		Thread.sleep(5000);
		gc.errorMsg();
		
	}

	@Test(priority=17,groups={"regression"})
	public void the_id_is_not_valid_and_user_gives_correct_email_id() throws InterruptedException, IOException {
		Thread.sleep(3000);
		gc.clrtext();
		gc.correctEmail();
		
		Thread.sleep(5000);
		
	}

}
