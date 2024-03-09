package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Utilities.Excel;

public class HomePage extends BasePage {
	
public HomePage(WebDriver driver) {
		
		super(driver);
	}

  

	@FindBy(id="search")
	WebElement search;
	
	@FindBy(id="search_button")
	WebElement srchBtn;
	
	@FindBy(xpath="//a[@class='close-reveal-modal hide-mobile']")
	WebElement popup;
	
	@FindBy(xpath="//*[@class=\"item\"]")
	WebElement category;
	
	@FindBy(xpath="//*[@id=\"filters_primary_category_Kids_Bookshelves\"]")
	WebElement kidshlf;
	
	@FindBy(xpath="//*[@data-group=\"price\"]/div[@class=\"gname\"]")
	WebElement price;
	
	@FindBy(xpath="//*[@class=\"noUi-handle noUi-handle-upper\"]")
	WebElement slider;
	
	@FindBy(xpath="//*[@name=\"filters[availability][]\"]")
	WebElement chkBox;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/span")
	WebElement sort;
	
	@FindBy(xpath="//*[@id=\"search-results\"]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div/div/ul/li[3]")
	WebElement hTl;
	
	
	@FindBy(xpath="//a[@class='product-title-block'][1]")
	List<WebElement> items;
	
	
	public void input() throws IOException
	{
		
		search.sendKeys(Excel.ExcelRead("BSsearch",0,0));
	}
	
	public void searchBtn(){
		srchBtn.click();
	}
	
	public void PopUp() {
		popup.click();
	}
	
	public void selectCategory() {
		category.click();
	}
	
	public void kidsBookShelves() {
		kidshlf.click();
	}
	
	
	
	public void selectSlider() {
		Actions action = new Actions(driver);
		action.moveToElement(price).click().perform();
		action.doubleClick(slider).perform();
		action.dragAndDropBy(slider, -211, 0).perform();
		
	}
	
	public void excludeOFS() {
		chkBox.click();
	}
	
	public void sortBy() {
		Actions action = new Actions(driver);
		action.moveToElement(sort).perform();
		
	}
	
	public void selectRange() {
		hTl.click();
	}
	
	public void getDetails() throws IOException {
		Excel excel = new Excel(System.getProperty("user.dir")+"//Excel//wbs.xlsx");
		for(int i=0;i<3;i++) {
			 String detail = items.get(i).getText();
			 System.out.println(detail);
			 excel.setCellData("BookShelves", i, 0,detail);
		}
	}

}
