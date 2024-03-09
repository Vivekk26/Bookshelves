package testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.HomePage;
import testBase.TestBase;
@Listeners(testCases.ExtentReport.class)

public class TC_03_getItems extends TestBase {
	
public HomePage hm;
	
	@Test(priority=8,groups={"regression"})
	
	public void fetch_the_top_three_items_print_all_details_in_console_output() throws InterruptedException, IOException {
		hm=new HomePage(driver);
		Thread.sleep(3000);
	    hm.getDetails();
	   
	}

}
