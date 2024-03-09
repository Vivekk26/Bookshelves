package stepDefinition;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import PageObject.ConfirmDetails;
import PageObject.GiftCard;
import PageObject.HomePage;
import PageObject.Living;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.Logger;

public class StepDef extends BaseClass {
	
	
	public HomePage hm;
	public Living lvng;
	public GiftCard gc;
	public ConfirmDetails cd;
	
	
	
	Logger logger=BaseClass.getLogger1();
	WebDriver driver = BaseClass.getDriver();
	Actions action = new Actions(driver);
	@Given("user opens urbanladder website")
	public void user_opens_urbanladder_website() {
		
		hm=new HomePage(driver);
		lvng=new Living(driver);
		gc=new GiftCard(driver);
		cd=new ConfirmDetails(driver);
		
		 logger.info("user opens urbanladder website");
		
		
	}

	@When("user searches for Bookshelves")
	public void user_searches_for_bookshelves() throws IOException, InterruptedException {
		hm.input();
		hm.searchBtn();
		hm.searchBtn();
		Thread.sleep(2000);
		hm.PopUp();
		logger.info("user searches for Bookshelves");
		
	   }

	@When("select the price range below fifteen thousand")
	public void select_the_price_range_below_fifteen_thousand() throws InterruptedException {
	  
	   Thread.sleep(3000);
	   hm.selectSlider();
	   logger.info("user selects the price range below fifteen thousand");
	}

	@When("chooses the category Kid Bookshelves")
	public void chooses_the_category_kid_bookshelves() throws InterruptedException {
		Thread.sleep(3000);
	    hm.selectCategory();
	    hm.kidsBookShelves();
	    logger.info("user chooses the category Kid Bookshelves");
	}

	@When("exclude out of stock")
	public void exclude_out_of_stock() throws InterruptedException {
		Thread.sleep(3000);
		hm.excludeOFS();
		logger.info("exclude out of stock");
	}

	@When("sorts by price High to Low")
	public void sorts_by_price_high_to_low() throws InterruptedException {
	    hm.sortBy();
	    Thread.sleep(3000);
	    hm.selectRange();
	    logger.info("sorts by price High to Low");
	}

	@Then("fetch the top three items & print all details in console output")
	public void fetch_the_top_three_items_print_all_details_in_console_output() throws InterruptedException, IOException {
		Thread.sleep(3000);
	  // hm.selectRange();
	   hm.getDetails();
	   logger.info("fetch the top three items & print all details in console output");
	}

	@When("user clicks on the living menu")
	public void user_clicks_on_the_living_menu() {
		action.keyUp(Keys.PAGE_UP).perform();
		lvng.selectLiving();
		logger.info("user clicks on the living menu");
	}

	@Then("retrieve all items under Living Storage sub-menu and print the same on the console")
	public void retrieve_all_items_under_living_storage_sub_menu_and_print_the_same_on_the_console() throws InterruptedException, IOException {
		Thread.sleep(3000);
		lvng.printSubMenu();
		lvng.getSubMenu();
		logger.info("retrieve all items under Living Storage sub-menu and print the same on the console");
	}

	@When("user clicks on gift cards")
	public void user_clicks_on_gift_cards() throws InterruptedException {
		action.keyUp(Keys.PAGE_UP).perform();
		gc.openGiftCards();
		Thread.sleep(3000);
	    gc.scrollPage();
	    logger.info("user clicks on gift cards");
	}

	@When("chooses Birthday or Anniversary")
	public void chooses_birthday_or_anniversary() throws InterruptedException {
		Thread.sleep(5000);
	   // gc.scrollPage();
	    gc.selectCard();
	    logger.info("user chooses Birthday or Anniversary");
	}

	@When("enters the valid amount, month and date")
	public void enters_the_valid_amount_month_and_date() throws InterruptedException, IOException {
		Thread.sleep(3000);
	   gc.selectAmnt();
	   gc.selectMonth();
	   gc.selectdate();
	   logger.info("user enters the valid amount, month and date");
	}

	@When("clicks on the next button")
	public void clicks_on_the_next_button() throws InterruptedException {
		Thread.sleep(3000);
	    gc.selectNext();
	    logger.info("user clicks on the next button");
	}

	@When("fills To & From details")
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
	   gc.clickCnfrmBtn();
	   
	   logger.info("user fills To & From details");
	}

	

	@Then("validate the email id")
	public void validate_the_email_id() throws InterruptedException, IOException {
		Thread.sleep(5000);
		gc.errorMsg();
		logger.info("validate the email id");
	}

	@When("the id is not valid and user gives correct email id")
	public void the_id_is_not_valid_and_user_gives_correct_email_id() throws InterruptedException, IOException {
		Thread.sleep(3000);
		gc.clrtext();
		gc.correctEmail();
		gc.clickCnfrmBtn();
		Thread.sleep(5000);
		logger.info("the id is not valid and user gives correct email id");
		
	}
	
	
	@Then("confirm the details in Confirm Details section")
	public void confirm_the_details_in_confirm_details_section() throws IOException, InterruptedException {
		Thread.sleep(3000);
		cd.chkRname();
	    cd.chkRmail();
	    cd.chkRphn();
	    cd.chkSname();
	    cd.chkSmail();
	    cd.chkSphn();
	    cd.chkScity();
	    logger.info("validate the details in Confirm Details section");
	}

	@Then("close the browser")
	public void close_the_browser() {
	    logger.info("close the browser");
	}



}
