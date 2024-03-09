package PageObject;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utilities.Excel;

public class GiftCard extends BasePage {
	
public GiftCard(WebDriver driver) {
		
		super(driver);
	}

	@FindBy(xpath="(//*[@class=\"featuredLinksBar__link\"])[3]")
	WebElement giftCard;
	
	@FindBy(xpath="(//*[@class=\"_11b4v\"])[3]")
	WebElement scrollto;
	
	@FindBy(xpath="(//*[@class=\"_11b4v\"])[3]")
	WebElement bOrA;
	
	@FindBy(xpath="//*[@id=\"ip_2251506436\"]")
	WebElement amnt;
	
	@FindBy(xpath="(//*[@class=\"Upz18 _1hLiD UJU2v\"])[1]")
	WebElement month;
	
	@FindBy(xpath="(//*[@class=\"Upz18 _1hLiD UJU2v\"])[2]")
	WebElement date;
	
	@FindBy(xpath="//*[@class=\"_1IFIb _1fVSi action-button _1gIUf _1XfDi\"]")
	WebElement nxt;
	
	@FindBy(xpath="//*[@id=\"ip_4036288348\"]")
	WebElement rname;
	
	@FindBy(xpath="//*[@id=\"ip_137656023\"]")
	WebElement rEmail;
	
	@FindBy(xpath="//*[@id=\"ip_3177473671\"]")
	WebElement rphn;
	
	
	@FindBy(xpath="//*[@id=\"ip_1082986083\"]")
	WebElement sname;
	
	@FindBy(xpath="//*[@id=\"ip_4081352456\"]")
	WebElement sEmail;
	
	@FindBy(xpath="//*[@id=\"ip_2121573464\"]")
	WebElement sphn;
	
	@FindBy(xpath="//*[@id=\"ip_2194351474\"]")
	WebElement add;
	
	@FindBy(xpath="//*[@id=\"ip_567727260\"]")
	WebElement pin;
	
	@FindBy(xpath="//*[@class=\"_3Hxyv _1fVSi action-button _1gIUf _1XfDi\"]")
	WebElement cnfrmBtn;
	
	
	
	public void openGiftCards() {
		giftCard.click();
	}
	
	public void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",scrollto);
	}
	
	public void selectCard() {
		bOrA.click();
	}
	
	public void selectAmnt() throws IOException {
		amnt.sendKeys(Excel.ExcelRead("GC",0,2));
	}
	
	public void selectMonth() throws IOException {
		Select mnth=new Select(month);
		mnth.selectByIndex(1);
	}
	
	public void selectdate() throws IOException {
		Select day=new Select(date);
		day.selectByIndex(1);
	}
	
	public void selectNext() {
		nxt.click();
	}
	
	public void setRName() throws IOException {
		rname.sendKeys(Excel.ExcelRead("GC",2,2));
	}
	
	public void setREmail() throws IOException {
		rEmail.sendKeys(Excel.ExcelRead("GC",2,3));
	}
	
	public void setRPhn() throws IOException {
		rphn.sendKeys(Excel.ExcelRead("GC",2,4));
	}
	
	public void setSName() throws IOException {
		sname.sendKeys(Excel.ExcelRead("GC",2,5));
	}
	
	public void setSEmail() throws IOException {
		sEmail.sendKeys(Excel.ExcelRead("GC",2,6));
	}
	
	public void setSPhn() throws IOException {
		sphn.sendKeys(Excel.ExcelRead("GC",2,7));
	}
	
	public void setAdd() throws IOException {
		add.sendKeys(Excel.ExcelRead("GC",2,8));
	}
	
	public void setPin() throws IOException {
		pin.sendKeys(Excel.ExcelRead("GC",2,9));
	}
	
	public void clickCnfrmBtn() {
		cnfrmBtn.click();
	}
	
	public void errorMsg() throws IOException, InterruptedException {
		String error=rEmail.getAttribute("validationMessage");
		Thread.sleep(6000);
		System.out.println(error);
	}
	
	public void clrtext() {
		rEmail.clear();
	}
	
	public void correctEmail() throws IOException, InterruptedException {
		rEmail.sendKeys(Excel.ExcelRead("GC",4,2));
		Thread.sleep(5000);
	}

}
