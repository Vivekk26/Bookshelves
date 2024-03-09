package testCases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.Living;
import testBase.TestBase;
@Listeners(testCases.ExtentReport.class)

public class TC_04_living extends TestBase {
	
	public Living lvng;
	
	
	@Test(priority=9,groups={"regression"})
	public void user_clicks_on_the_living_menu() {
		lvng=new Living(driver);
		Actions action = new Actions(driver);
		action.keyUp(Keys.PAGE_UP).perform();
		lvng.selectLiving();
		
	}

	@Test(priority=10,groups={"regression"})
	public void retrieve_all_items_under_living_storage_sub_menu_and_print_the_same_on_the_console() throws InterruptedException, IOException {
		Thread.sleep(3000);
		lvng.printSubMenu();
		lvng.getSubMenu();
		
	}

}
