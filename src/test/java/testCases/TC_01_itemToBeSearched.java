package testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.HomePage;

import testBase.TestBase;

@Listeners(testCases.ExtentReport.class)

public class TC_01_itemToBeSearched extends TestBase{
	
	public HomePage hm;
	
	
	@Test(priority=1,groups={"smoke","regression"})
	public void openBrowser() throws IOException, InterruptedException {
		hm=new HomePage(driver);
		Thread.sleep(2000);	
		hm.input();
		
	}
	
	@Test(priority=2,groups={"regression"})
	public void getItemName() throws IOException, InterruptedException {
		Thread.sleep(2000);
		hm.searchBtn();

		
	}
	
	@Test(priority=3,groups={"regression"})
	public void closePopUp() throws InterruptedException {
		
		Thread.sleep(2000);
		hm.PopUp();
	}
	
	
}
