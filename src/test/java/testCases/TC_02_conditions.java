package testCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.HomePage;
import testBase.TestBase;
@Listeners(testCases.ExtentReport.class)

public class TC_02_conditions extends TestBase  {
	
	public HomePage hm;
	
	@Test(priority=4,groups={"regression"})
	public void select_the_price_range_below_fifteen_thousand() throws InterruptedException {
		  
		 hm=new HomePage(driver);
		   Thread.sleep(3000);
		   hm.selectSlider();
		  
		   
		}
	
	@Test(priority=5,groups={"regression"})
	public void chooses_the_category_kid_bookshelves() throws InterruptedException {
		Thread.sleep(3000);
	    hm.selectCategory();
	    hm.kidsBookShelves();
	   
	}
	@Test(priority=6,groups={"regression"})
	public void exclude_out_of_stock() throws InterruptedException {
		Thread.sleep(3000);
		hm.excludeOFS();
		
	}
	
	@Test(priority=7,groups={"regression"})
	public void sorts_by_price_high_to_low() throws InterruptedException {
	    hm.sortBy();
	    Thread.sleep(3000);
	    hm.selectRange();
	   
	}

}
